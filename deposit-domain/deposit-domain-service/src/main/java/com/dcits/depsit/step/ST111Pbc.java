package com.dcits.depsit.step;

import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.facade.bo.ST111InputBO;
import com.dcits.depsit.facade.bo.ST111OutputBO;
import com.dcits.depsit.facade.components.IRbClientRestraintsBcc;
import com.dcits.depsit.facade.eo.RbClientRestraintsEO;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST111 检查客户是否存在限制 —— 步骤实现。
 *
 * <p>编排（源需求「## 步骤描述」子步骤 1、2）：</p>
 * <ol>
 *   <li>子步骤 1：以入参 {客户号}（{@code clientNo}）为客户号、以限制状态码值 {@code "A"}
 *       （需求写作「A-生效」，按「码值-含义」取码值判定）为条件查询【客户限制表】
 *       （{@code RB_CLIENT_RESTRAINTS}）；取回记录须包含账户限制类型与限制编号。
 *       查不到记录时限制编号、账户限制类型、限制状态均为空值；查得多条记录时按限制编号
 *       升序取第一条，并以该条的限制编号、账户限制类型、限制状态作为回显取值。</li>
 *   <li>子步骤 2：把子步骤 1 确定的三项取值赋值为客户限制信息并返回 [客户限制信息]；
 *       查询结果为空（三项均为空值）时同样返回，不跳过返回、不产生业务失败结论。</li>
 * </ol>
 *
 * <p>本步骤无业务失败场景（Spec REQ-006）：正常完成即设置 {@code succeed = true} 并保持
 * 错误字段为 {@code null}；数据访问或运行环境异常按技术异常向上传播，本实现不新增
 * {@code catch}、不吞异常、不转换为业务失败结论、不以占位值兜底。本步骤只读取数，
 * 无本地写入，不引入事务。</p>
 *
 * <p>本步骤无组件内步骤调用与跳转目标（Spec「不在范围内」第 10 项），不调用其它步骤或规则。</p>
 */
@Service
public class ST111Pbc implements IST111 {

    /** 子步骤 1 的查询条件：限制状态码值 {@code "A"}（需求「A-生效」，按码值判定，REQ-001）。 */
    private static final RestraintsStatus RESTRAINTS_STATUS_QUERY = RestraintsStatus.A;

    /** 【客户限制表(RB_CLIENT_RESTRAINTS)】数据服务接口。 */
    @Autowired
    private IRbClientRestraintsBcc irRbClientRestraintsBcc;

    @Override
    public ST111OutputBO execute(ST111InputBO input) {
        ST111OutputBO output = new ST111OutputBO();

        // 子步骤 1「获取客户限制信息」：以 {客户号} + 限制状态码值 "A" 为条件查询【客户限制表】（REQ-001）
        RbClientRestraintsEO condition = new RbClientRestraintsEO();
        condition.setClientNo(input.getClientNo());
        condition.setRestraintsStatus(RESTRAINTS_STATUS_QUERY);
        List<RbClientRestraintsEO> records = irRbClientRestraintsBcc.findByEo(condition);

        // 子步骤 1「查得多条记录」分支：按限制编号升序取第一条（REQ-003）；
        // 「查不到记录」分支（结果为空）返回 null，三项取值保持空值（REQ-002）
        RbClientRestraintsEO hit = selectFirstByResSeqNo(records);

        // 子步骤 2：赋值客户限制信息（REQ-004、REQ-005）——命中路径取回显记录的三项取值，
        // 查询结果为空路径三项保持空值，且均返回 [客户限制信息]
        if (hit != null) {
            output.setResSeqNo(hit.getResSeqNo());
            output.setRestraintType(hit.getRestraintType());
            output.setRestraintsStatus(hit.getRestraintsStatus());
        }

        // 「## 失败处理」声明本步骤无业务失败场景，正常完成即成功，错误字段保持 null（REQ-006）
        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤 1 的取首：结果为空时返回 {@code null}；否则按限制编号升序取第一条（REQ-003）。
     *
     * <p>限制编号在本项目为 {@code java.lang.String}（库列 {@code RES_SEQ_NO VARCHAR}），
     * 按字符串自然升序（字典序）比较；需求未规定更细的比较规则（Spec「验收范围与明确不覆盖
     * 的事项」第 3 项）。取首依据仅为限制编号，与查询返回顺序无关。</p>
     */
    private RbClientRestraintsEO selectFirstByResSeqNo(List<RbClientRestraintsEO> records) {
        if (records == null || records.isEmpty()) {
            return null;
        }
        // 取回记录必须包含限制编号；对缺失编号的记录按末位兜底，该情形不属于本轮验收范围
        Comparator<RbClientRestraintsEO> byResSeqNo = Comparator.comparing(
                RbClientRestraintsEO::getResSeqNo,
                Comparator.nullsLast(Comparator.<String>naturalOrder()));
        return Collections.min(records, byResSeqNo);
    }
}
