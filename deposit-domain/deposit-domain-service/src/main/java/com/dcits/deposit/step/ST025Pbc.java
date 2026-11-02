package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST025InputBO;
import com.dcits.deposit.facade.bo.ST025OutputBO;
import com.dcits.deposit.facade.bo.ST050InputBO;
import com.dcits.deposit.facade.bo.ST050OutputBO;
import com.dcits.deposit.facade.bo.ST055InputBO;
import com.dcits.deposit.facade.bo.ST055OutputBO;
import com.dcits.deposit.facade.bo.ST058InputBO;
import com.dcits.deposit.facade.bo.ST058OutputBO;

/**
 * ST025 检查法透账户支取限制 步骤实现。
 *
 * <p>按正式 Spec 步骤描述第 1–6 条执行：以必填输入账号（baseAcctNo）为 {账号} 依次调用组件内
 * 步骤「检查是否存在不收不付限制」ST058、「检查是否存在止付限制」ST055、「检查有权机关冻结
 * 限制」ST050，取得三个标志并按序判定：任一标志等于「是」时返回对应错误码（ER0059 / ER0065 /
 * ER0066）短路失败；三个标志均不为「是」时返回检查结果「通过」并正常完成，按「输出」表返回
 * 三个标志字段。</p>
 *
 * <p>错误码与错误信息按正式 Spec 步骤结果契约及 errorcodes.properties：ER0059=账户存在不收
 * 不付限制、ER0065=账户存在止付限制、ER0066=账户存在有权机关冻结限制，errorMessage 采用
 * {@code 错误码::业务说明} 格式。组件内步骤调用绑定见正式 Spec「组件内步骤调用绑定」表
 * （ST058/ST055/ST050，步骤 1 的 ST058 绑定为正式 Spec 待确认事项 TBD-5）。</p>
 *
 * <p>待确认事项：三个标志「是」/「否」物理编码（TBD-1）、「通过」结论承载方式（TBD-2）、
 * baseAcctNo 缺失行为（TBD-3，需求未声明失败分支，本实现不新增校验）、失败路径输出填充
 * （TBD-4）及目标步骤自身返回业务失败时的处理，见执行中 FIXME。</p>
 */
@Service
public class ST025Pbc implements IST025 {

    private final IST058 st058;
    private final IST055 st055;
    private final IST050 st050;

    public ST025Pbc(IST058 st058, IST055 st055, IST050 st050) {
        this.st058 = st058;
        this.st055 = st055;
        this.st050 = st050;
    }

    @Override
    public ST025OutputBO execute(ST025InputBO input) {
        ST025OutputBO output = new ST025OutputBO();
        String baseAcctNo = input.getBaseAcctNo();

        // 步骤1（步骤描述第1条 / REQ-002）：以 {账号}=baseAcctNo 调用组件内步骤「检查是否存在不收不付限制」ST058 获取[不收不付标志]
        // FIXME 业务项:ST025/检查法透账户支取限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:输入 baseAcctNo 标记必填，但需求未定义其为空或缺失时的校验与失败行为（是否校验失败及相应错误码，正式 Spec 待确认事项 TBD-3） - 影响:当前实现不校验必填，空值直接作为三个组件内步骤调用的 {账号} 参数透传 - 待确认:baseAcctNo 为空或缺失时应如何校验、返回错误码或直接失败
        ST058InputBO st058Input = new ST058InputBO();
        st058Input.setBaseAcctNo(baseAcctNo);
        ST058OutputBO st058Result = st058.execute(st058Input);
        // FIXME 业务项:ST025/检查法透账户支取限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:组件内步骤 ST058 返回业务失败（succeed=false）时本步骤的传播/转换行为未定义（正式 Spec 仅定义标志等于「是」时的 ER0059 失败与「不再执行后续步骤」，未定义目标步骤自身失败的处理） - 影响:当前实现将目标步骤失败状态（succeed=false 及 errorCode/errorMessage）原样传播到本步骤输出并终止，该行为待业务确认 - 待确认:目标步骤返回业务失败时 ST025 应如何传播、转换或处理
        if (!st058Result.isSucceed()) {
            output.setSucceed(false);
            output.setErrorCode(st058Result.getErrorCode());
            output.setErrorMessage(st058Result.getErrorMessage());
            return output;
        }
        String noCreditNoDebitFlag = st058Result.getNoCreditNoDebitFlag();
        output.setNoCreditNoDebitFlag(noCreditNoDebitFlag);

        // 步骤2（步骤描述第2条 / REQ-003）：若[不收不付标志]等于「是」→ 返回 ER0059 业务失败并停止；否则继续执行
        // FIXME 业务项:ST025/检查法透账户支取限制 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:三个标志（不收不付标志、止付标志、有权机关冻结标志）业务取值「是」/「否」的物理编码未确认（正式 Spec 待确认事项 TBD-1），当前按业务取值字面量「是」判定（ST058/ST055 当前实现输出字面量「是」/「否」，ST050 的 ahBuFlag 为查询结果原样透传、编码未确认） - 影响:若确认后标志采用其他编码（如 Y/N、1/0 或字面量），本判定及输出字段取值需复核 - 待确认:各标志的实际物理编码及 ST025 判定「等于'是'」所依据的取值口径
        if ("是".equals(noCreditNoDebitFlag)) {
            // FIXME 业务项:ST025/检查法透账户支取限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:失败路径下「输出」表字段（不收不付标志、stopFlag、ahBuFlag）的填充取值未定义（正式 Spec 待确认事项 TBD-4），如 ER0059 路径下止付标志、有权机关冻结标志因短路未被获取 - 影响:当前实现按自然取值填充（已获取的标志正常赋值，未获取的保持 null），该取值待业务确认 - 待确认:失败返回时各输出字段的取值（返回已获取的标志、置空或整体不返回）
            output.setSucceed(false);
            output.setErrorCode("ER0059");
            output.setErrorMessage("ER0059::账户存在不收不付限制");
            return output;
        }

        // 步骤3（步骤描述第3条 / REQ-004）：以 {账号}=baseAcctNo 调用组件内步骤「检查是否存在止付限制」ST055 获取[止付标志]（stopFlag）
        ST055InputBO st055Input = new ST055InputBO();
        st055Input.setBaseAcctNo(baseAcctNo);
        ST055OutputBO st055Result = st055.execute(st055Input);
        // FIXME 业务项:ST025/检查法透账户支取限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:组件内步骤 ST055 返回业务失败（succeed=false）时本步骤的传播/转换行为未定义（正式 Spec 未定义目标步骤自身失败的处理） - 影响:当前实现将目标步骤失败状态（succeed=false 及 errorCode/errorMessage）原样传播到本步骤输出并终止，该行为待业务确认 - 待确认:目标步骤返回业务失败时 ST025 应如何传播、转换或处理
        if (!st055Result.isSucceed()) {
            output.setSucceed(false);
            output.setErrorCode(st055Result.getErrorCode());
            output.setErrorMessage(st055Result.getErrorMessage());
            return output;
        }
        String stopFlag = st055Result.getStopFlag();
        output.setStopFlag(stopFlag);

        // 步骤4（步骤描述第4条 / REQ-005）：若[止付标志]等于「是」→ 返回 ER0065 业务失败并停止；否则继续执行
        if ("是".equals(stopFlag)) {
            output.setSucceed(false);
            output.setErrorCode("ER0065");
            output.setErrorMessage("ER0065::账户存在止付限制");
            return output;
        }

        // 步骤5（步骤描述第5条 / REQ-006）：以 {账号}=baseAcctNo 调用组件内步骤「检查有权机关冻结限制」ST050 获取[有权机关冻结标志]（ahBuFlag）
        ST050InputBO st050Input = new ST050InputBO();
        st050Input.setBaseAcctNo(baseAcctNo);
        ST050OutputBO st050Result = st050.execute(st050Input);
        // FIXME 业务项:ST025/检查法透账户支取限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:组件内步骤 ST050 返回业务失败（succeed=false）时本步骤的传播/转换行为未定义（正式 Spec 未定义目标步骤自身失败的处理） - 影响:当前实现将目标步骤失败状态（succeed=false 及 errorCode/errorMessage）原样传播到本步骤输出并终止，该行为待业务确认 - 待确认:目标步骤返回业务失败时 ST025 应如何传播、转换或处理
        if (!st050Result.isSucceed()) {
            output.setSucceed(false);
            output.setErrorCode(st050Result.getErrorCode());
            output.setErrorMessage(st050Result.getErrorMessage());
            return output;
        }
        String ahBuFlag = st050Result.getAhBuFlag();
        output.setAhBuFlag(ahBuFlag);

        // 步骤6（步骤描述第6条 / REQ-007）：若[有权机关冻结标志]等于「是」→ 返回 ER0066 业务失败；否则返回检查结果「通过」正常完成
        if ("是".equals(ahBuFlag)) {
            output.setSucceed(false);
            output.setErrorCode("ER0066");
            output.setErrorMessage("ER0066::账户存在有权机关冻结限制");
            return output;
        }

        // 正常完成：检查结果「通过」，显式成功并清空错误字段
        // FIXME 业务项:ST025/检查法透账户支取限制 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:「检查结果为通过」的承载方式未定义（需求「输出」表未登记「检查结果」字段，通过结论以专用输出字段还是以步骤成功状态承载，正式 Spec 待确认事项 TBD-2） - 影响:当前实现以 succeed=true 且 errorCode/errorMessage 为空承载「通过」结论，无独立输出字段 - 待确认:「通过」是否需要独立业务输出字段及其编码
        output.setSucceed(true);
        output.setErrorCode(null);
        output.setErrorMessage(null);
        return output;
    }
}
