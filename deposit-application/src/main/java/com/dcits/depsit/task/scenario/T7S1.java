package com.dcits.depsit.task.scenario;

import com.dcits.common.task.RespHeader;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.facade.bo.ST111InputBO;
import com.dcits.depsit.facade.bo.ST111OutputBO;
import com.dcits.depsit.step.IST111;
import com.dcits.depsit.task.dto.T7S1InputDTO;
import com.dcits.depsit.task.dto.T7S1OutputDTO;
import org.springframework.stereotype.Component;

/**
 * T7S1 检查客户限制 —— 交易场景。
 *
 * <p>编排（源需求「## 执行步骤」表，本交易唯一一步）：按声明顺序调用组件内步骤
 * {@code ST111}「检查客户是否存在限制」一次，把交易入参 {@code clientNo} 原样作为该步骤的入参
 * {客户号}（{@code ST111InputBO.clientNo}）传入，随后把步骤业务输出 {@code resSeqNo}／
 * {@code restraintType}／{@code restraintsStatus} 按字段名一一映射为交易业务输出三字段
 * （REQ-002、REQ-003）。</p>
 *
 * <p>映射口径（REQ-004）：{@code resSeqNo} 取步骤输出 {@code String} 原值；
 * {@code restraintType}／{@code restraintsStatus} 分别取枚举
 * {@link RestraintType}／{@link RestraintsStatus} 的码值字符串（{@code getValue()}），
 * 对外 DTO 以 {@code String} 承载，MUST NOT 输出枚举常量名或 {@code toString()} 形式。
 * 步骤按其自身规则给出结果（命中一条、多条按限制编号升序取首、查询结果为空时三字段为空值），
 * 交易层不重新排序、不重新取首、不在交易层引入需求「## 输出」表之外的映射来源（REQ-003）。</p>
 *
 * <p>响应头口径（REQ-005）：步骤正常完成（含查询结果为空）时显式置
 * {@code succeed = true} 并清空 {@code errorCode}／{@code errorMessage}；响应头与交易业务输出
 * 为两个独立对象，成功状态不通过业务输出对象承载。</p>
 *
 * <p>无业务失败结论（REQ-006）：本交易唯一被调步骤的正式 Spec 声明无业务失败场景
 * （{@code succeed = false} 在本交易可达路径下不发生），需求正文亦无「## 失败处理」章节，
 * 故本场景不设置业务错误码、不引用错误码资源、不新增失败分支；依赖的数据访问或运行环境异常
 * 按技术异常向上传播，本场景不捕获、不包装、不以占位值兜底。</p>
 *
 * <p>事务口径（技术核对，非业务新增）：唯一被调步骤为只读检查，本交易不新增、修改或删除任何
 * 数据（本任务事务边界判定结论：写入集合仅含只读步骤 {@code ST111}），{@link IST111} 的
 * Javadoc 亦声明调用方无需事务，故本场景不添加事务注解。</p>
 */
@Component
public class T7S1 {

    /** 唯一被调步骤：ST111 检查客户是否存在限制（只读检查，无业务失败场景）。 */
    private final IST111 st111;

    public T7S1(IST111 st111) {
        this.st111 = st111;
    }

    /**
     * 执行「检查客户限制」交易。
     *
     * @param header 调用方传入的响应头，保留同一实例；本次执行正常完成时置
     *               {@code succeed = true} 并清空错误字段
     * @param input  交易对外输入，业务字段仅 {@code clientNo}（客户号）
     * @return 交易对外业务输出 {@code resSeqNo}／{@code restraintType}／{@code restraintsStatus}
     */
    public T7S1OutputDTO execute(RespHeader header, T7S1InputDTO input) {
        T7S1OutputDTO output = new T7S1OutputDTO();

        // 执行步骤 1（唯一一步）：ST111「检查客户是否存在限制」。
        // 交易入参 clientNo 原值传入步骤入参 {客户号}，不做变形、不补默认值（REQ-002）
        ST111InputBO st111Input = new ST111InputBO();
        st111Input.setClientNo(input.getClientNo());

        ST111OutputBO st111Output = st111.execute(st111Input);

        // 步骤业务输出逐字段映射为交易业务输出（REQ-003、REQ-004）：
        // resSeqNo 取 String 原值；两个枚举字段取业务码值字符串，空值保持空值
        output.setResSeqNo(st111Output.getResSeqNo());
        output.setRestraintType(codeOf(st111Output.getRestraintType()));
        output.setRestraintsStatus(codeOf(st111Output.getRestraintsStatus()));

        // 步骤正常完成（含查询结果为空）即为成功响应；显式清理复用响应头中的旧错误（REQ-005）
        header.setSucceed(true);
        header.setErrorCode(null);
        header.setErrorMessage(null);
        return output;
    }

    /**
     * 把步骤输出的 {@link RestraintType} 转换为对外业务编码：取枚举已声明的
     * {@code getValue()} 码值字符串，不以常量名或 {@code toString()} 代替（REQ-004）。
     *
     * @param restraintType 步骤输出的账户限制类型，查询结果为空时为 {@code null}
     * @return 码值字符串；入参为空值时返回 {@code null}（空值保持空值，不占位）
     */
    private static String codeOf(RestraintType restraintType) {
        return restraintType == null ? null : restraintType.getValue();
    }

    /**
     * 把步骤输出的 {@link RestraintsStatus} 转换为对外业务编码：取枚举已声明的
     * {@code getValue()} 码值字符串（已确认码值 {@code A}／{@code E}／{@code F}）。
     *
     * @param restraintsStatus 步骤输出的限制状态，查询结果为空时为 {@code null}
     * @return 码值字符串；入参为空值时返回 {@code null}（空值保持空值，不占位）
     */
    private static String codeOf(RestraintsStatus restraintsStatus) {
        return restraintsStatus == null ? null : restraintsStatus.getValue();
    }
}
