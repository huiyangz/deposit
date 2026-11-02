package com.dcits.deposit.step;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST040InputBO;
import com.dcits.deposit.facade.bo.ST040OutputBO;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST040 检查限额 步骤实现。
 */
@Service
public class ST040Pbc implements IST040 {

    private final IRbLimitCtrlConfBcc limitCtrlConfBcc;

    public ST040Pbc(IRbLimitCtrlConfBcc limitCtrlConfBcc) {
        this.limitCtrlConfBcc = limitCtrlConfBcc;
    }

    @Override
    public ST040OutputBO execute(ST040InputBO input) {
        ST040OutputBO output = new ST040OutputBO();
        // 子步骤 获取限额控制值：根据限额场景编码查询限额控制配置，取得限额控制金额与限额控制笔数
        RbLimitCtrlConfEO conf = queryLimitCtrlConf(input.getLimitSceneNo());
        if (conf != null) {
            output.setLimitCtrlAmt(conf.getLimitCtrlAmt());
            output.setLimitCtrlNum(conf.getLimitCtrlNum());
        }
        // 子步骤 检查限额：限额累计金额与累计笔数按输入承接为输出
        output.setLimitSumAmt(input.getLimitSumAmt());
        output.setLimitSumNum(input.getLimitSumNum());
        // 子步骤 检查限额：限额累计金额大于限额控制金额，或限额累计笔数大于限额控制笔数时返回「超限」，否则返回「未超限」
        output.setLimitCheckResult(checkLimit(input.getLimitSumAmt(), input.getLimitSumNum(),
                conf == null ? null : conf.getLimitCtrlAmt(),
                conf == null ? null : conf.getLimitCtrlNum()));
        // 超限/未超限为正常完成时返回的业务结论，本步无业务失败场景
        output.setSucceed(true);
        return output;
    }

    /**
     * 根据限额场景编码查询限额控制配置，多条时取结果集第一条。
     */
    private RbLimitCtrlConfEO queryLimitCtrlConf(String limitSceneNo) {
        // FIXME 业务项:ST040/检查限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:限额控制配置查询的唯一性、附加条件与无记录行为未定义（Spec 待确认事项 TBD-3）：表主键为（限额机构编码，限额场景编码），需求仅提供 limitSceneNo，未声明机构维度、启用标志（validFlag）或生效期间过滤；同一限额场景编码跨机构多条记录如何取对应配置、查询无命中记录时限额控制金额/笔数无值及比较行为均未定义 - 影响:当前按 findByEo 仅以 limitSceneNo 查询并取结果集第一条，无命中记录时不设置限额控制值，检查结果受空值比较语义（TBD-6）影响 - 待确认:查询附加条件/机构维度、多条记录选取规则及无记录行为
        RbLimitCtrlConfEO query = new RbLimitCtrlConfEO();
        query.setLimitSceneNo(limitSceneNo);
        List<RbLimitCtrlConfEO> confs = limitCtrlConfBcc.findByEo(query);
        if (confs == null || confs.isEmpty()) {
            return null;
        }
        return confs.get(0);
    }

    /**
     * 检查限额：限额累计金额大于限额控制金额，或限额累计笔数大于限额控制笔数时超限；
     * 两条件为「或」关系，「大于」为严格大于（相等不超限）。
     */
    private String checkLimit(BigDecimal sumAmt, Integer sumNum, BigDecimal ctrlAmt, Integer ctrlNum) {
        // FIXME 业务项:ST040/检查限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:空值比较语义未定义（Spec 待确认事项 TBD-6）：限额控制金额/笔数或限额累计金额/笔数为 null 时「超限」「未超限」比较结果未定义（如控制值空是否视为无限额、累计值空是否视为 0 或报错） - 影响:任一参与比较的值为 null 时当前不生成限额检查结果（返回 null，limitCheckResult 保持空），既不按超限也不按未超限处理 - 待确认:null 时比较应如何判定
        if (sumAmt == null || sumNum == null || ctrlAmt == null || ctrlNum == null) {
            return null;
        }
        boolean amtOver = sumAmt.compareTo(ctrlAmt) > 0;
        boolean numOver = sumNum > ctrlNum;
        return amtOver || numOver ? "超限" : "未超限";
    }
}
