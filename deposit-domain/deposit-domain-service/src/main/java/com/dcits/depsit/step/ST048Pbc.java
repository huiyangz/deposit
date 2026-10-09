package com.dcits.depsit.step;

import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.facade.bo.ST048InputBO;
import com.dcits.depsit.facade.bo.ST048OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST048 检查存入账户账户属性 步骤实现。
 *
 * <p>子步骤：
 * <ol>
 *   <li>获取账户属性：根据 {账号} 查询【账户信息】获取 [账户属性]；查不到对应【账户信息】时 [账户属性] 为空，
 *       此时按 [账户属性] 不是「验资户」、也不是「临时户」处理。</li>
 *   <li>检查账户属性：若 [账户属性] 为「验资户」或「临时户」，则跳转至步骤《检查账户到期日》，
 *       否则返回检查结果为「通过」。</li>
 * </ol>
 * 本步骤为只读检查，不新增、修改或删除任何数据。</p>
 */
@Service
public class ST048Pbc implements IST048 {

    /** 对公存款账户主表（RB_BUS_ACCT）数据服务接口，承载步骤 1 的【账户信息】查询。 */
    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    @Override
    public ST048OutputBO execute(ST048InputBO input) {
        ST048OutputBO output = new ST048OutputBO();

        // 子步骤 ST048-01 获取账户属性：根据 {账号} 查询【账户信息】取得 [账户属性]
        AcctNatureNo acctNatureNo = getAcctNatureNo(input.getBaseAcctNo());
        output.setAcctNatureNo(acctNatureNo);

        // 子步骤 ST048-02 检查账户属性：为「验资户」或「临时户」则跳转至步骤《检查账户到期日》
        if (AcctNatureNo.VALUE_17 == acctNatureNo || AcctNatureNo.VALUE_11003 == acctNatureNo) {
            // 跳转分支：不表现为检查结果为「通过」，也不以错误码表达该结论
            return output;
        }

        // 否则（含查不到记录、[账户属性] 为空）返回检查结果为「通过」
        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤 ST048-01：按账号查询【账户信息】并取得 [账户属性]。
     *
     * <p>账号唯一对应一条【账户信息】，查不到对应记录时 [账户属性] 为空。</p>
     *
     * @param baseAcctNo 账号
     * @return 该账号对应账户记录的账户属性；查不到记录时为 {@code null}
     */
    private AcctNatureNo getAcctNatureNo(String baseAcctNo) {
        RbBusAcctEO condition = new RbBusAcctEO();
        condition.setBaseAcctNo(baseAcctNo);
        List<RbBusAcctEO> records = rbBusAcctBcc.findByEo(condition);
        if (records == null || records.isEmpty()) {
            return null;
        }
        // 源需求声明账号唯一对应一条【账户信息】，取该条记录的账户属性作为判定依据
        return records.get(0).getAcctNatureNo();
    }
}
