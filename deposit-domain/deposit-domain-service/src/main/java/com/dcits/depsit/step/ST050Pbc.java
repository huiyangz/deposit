package com.dcits.depsit.step;

import com.dcits.depsit.enums.CrDrInd;
import com.dcits.depsit.facade.bo.ST050InputBO;
import com.dcits.depsit.facade.bo.ST050OutputBO;
import org.springframework.stereotype.Service;

/**
 * ST050 设置贷记交易的借贷标志 步骤实现（交易执行步骤）。
 *
 * <p>唯一业务动作：将 [借贷标志] 赋值为常量“贷方”。源需求第 5 行写作「赋值[借贷标志]为“C-贷方”」，
 * 属「码值-含义」书写形式，规范取值为码值 {@code "C"}，对应枚举常量 {@link CrDrInd#C}（REQ-001）。</p>
 *
 * <p>本步骤无输入、无子步骤、无分支与循环，取值不依据任何入参、账户/产品/机构/交易数据或运行环境，
 * 也不查询实体、不调用 BCC / Mapper / 数据库 / 外部接口 / 其它组件步骤，不产生写入（REQ-002）；
 * 故实现不注入任何依赖，{@code execute} 亦不使用 {@code @Transactional}。</p>
 *
 * <p>正常完成时设置 {@code succeed = true}，错误码与错误信息保持 {@code null}。源需求「## 失败处理」声明
 * 本步骤无业务失败场景，失败仅由技术异常按工程既有方式向上传播，实现不捕获异常、不返回兜底取值（REQ-003）。</p>
 */
@Service
public class ST050Pbc implements IST050 {

    /** [借贷标志] 的常量取值：贷方（码值 {@code "C"}），本步骤取值恒为该常量。 */
    private static final CrDrInd CR_DR_IND = CrDrInd.C;

    /**
     * 执行「设置贷记交易的借贷标志」：赋值 [借贷标志] 为“贷方”并返回。
     *
     * @param input 步骤输入，本步骤无业务输入字段
     * @return 步骤输出，{@code crDrInd} 恒为 {@link CrDrInd#C}，{@code succeed} 为 {@code true}
     */
    @Override
    public ST050OutputBO execute(ST050InputBO input) {
        ST050OutputBO output = new ST050OutputBO();

        // 步骤描述 1：赋值借贷标志：赋值[借贷标志]为“C-贷方”
        output.setCrDrInd(CR_DR_IND);

        output.setSucceed(true);
        return output;
    }
}
