package com.dcits.deposit.rule;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.TaxResidentFlag;

/**
 * BR006 设置自贸区种类
 *
 * <p>规则类型：决策类。按客户类型、对私客户标志、税收居民标识、境内境外标志决定账户属性（自贸区种类），
 * 返回 {@link AcctNatureNo} 的取值代码；条件 a–e 均不满足时返回空值（null）。</p>
 */
public class BR006 {

    /**
     * 设置自贸区种类。
     *
     * @param isIndividual    对私客户标志，命中值 "Y"-个人
     * @param taxResidentFlag 税收居民标识
     * @param clientType      客户类型
     * @param inlandOffshore  境内境外标志，"Y"-境内、"N"-境外
     * @return 账户属性（自贸区种类）取值代码：FTI→"3605"、FTF→"3606"、FTE→"3603"、FTN→"3604"、FTU→"3607"；条件 a–e 均不满足时返回 null
     */
    public static String execute(String isIndividual,
                                 TaxResidentFlag taxResidentFlag,
                                 ClientType clientType,
                                 String inlandOffshore) {
        // a.客户类型=100-个人 且 对私客户标志=Y，且（税收居民标识=1 或 3）：FTI-区内个人自由贸易账户
        if (clientType == ClientType.VALUE_100
                && "Y".equals(isIndividual)
                && (taxResidentFlag == TaxResidentFlag.VALUE_1 || taxResidentFlag == TaxResidentFlag.VALUE_3)) {
            return AcctNatureNo.VALUE_3605.getValue();
        }
        // b.客户类型=100-个人 且 税收居民标识=2：FTF-区内境外个人自由贸易账户
        if (clientType == ClientType.VALUE_100 && taxResidentFlag == TaxResidentFlag.VALUE_2) {
            return AcctNatureNo.VALUE_3606.getValue();
        }
        // c.客户类型=200-对公 且 境内境外标志=Y-境内：FTE-区内机构自由贸易账户
        if (clientType == ClientType.VALUE_200 && "Y".equals(inlandOffshore)) {
            return AcctNatureNo.VALUE_3603.getValue();
        }
        // d.客户类型=200-对公 且 境内境外标志=N-境外：FTN-境外机构自由贸易账户
        if (clientType == ClientType.VALUE_200 && "N".equals(inlandOffshore)) {
            return AcctNatureNo.VALUE_3604.getValue();
        }
        // e.客户类型=300-同业 且 境内境外标志=N-境外：FTU-同业机构自由贸易账户
        if (clientType == ClientType.VALUE_300 && "N".equals(inlandOffshore)) {
            return AcctNatureNo.VALUE_3607.getValue();
        }
        // f.以上条件均不满足：返回空值
        return null;
    }
}
