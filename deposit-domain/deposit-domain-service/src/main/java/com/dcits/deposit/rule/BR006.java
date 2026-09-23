package com.dcits.deposit.rule;

import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.TaxResidentFlag;

/**
 * BR006 设置自贸区种类
 *
 * 依据门禁通过版 SPEC（docs/specs/BR006.md）实现，条件比较与返回值均取「代码-含义」表示法的代码部分：
 * a.对私客户标志="Y" 且 税收居民标志="1"或"3"，返回 "FTI"（区内个人自由贸易账户）；
 * b.客户类型="100" 且 税收居民标志="2"，返回 "FTF"（区内境外个人自由贸易账户）；
 * c.客户类型="200" 且 境内境外标志="Y"，返回 "FTE"（区内机构自由贸易账户）；
 * d.客户类型="200" 且 境内境外标志="N"，返回 "FTN"（境外机构自由贸易账户）；
 * e.客户类型="300" 且 境内境外标志="N"，返回 "FTU"（同业机构自由贸易账户）。
 */
public class BR006 {

    /**
     * 设置自贸区种类
     *
     * @param isIndividual 对私客户标志
     * @param taxResidentFlag 税收居民标识
     * @param clientType 客户类型
     * @param inlandOffshore 境内境外标志
     * @return acctNatureNo 账户属性编号（自贸区种类代码）
     */
    public static String execute(String isIndividual, TaxResidentFlag taxResidentFlag,
            ClientType clientType, String inlandOffshore) {
        // 分支 a：对私客户且税收居民标志为 1-中国税收居民 或 3-既是中国税收居民又是其他国家（地区）税收居民
        if ("Y".equals(isIndividual)
                && (TaxResidentFlag.VALUE_1 == taxResidentFlag || TaxResidentFlag.VALUE_3 == taxResidentFlag)) {
            return "FTI";
        }
        // 分支 b：个人客户且税收居民标志为 2-非中国税收居民
        if (ClientType.VALUE_100 == clientType && TaxResidentFlag.VALUE_2 == taxResidentFlag) {
            return "FTF";
        }
        // 分支 c：对公客户且境内
        if (ClientType.VALUE_200 == clientType && "Y".equals(inlandOffshore)) {
            return "FTE";
        }
        // 分支 d：对公客户且境外
        if (ClientType.VALUE_200 == clientType && "N".equals(inlandOffshore)) {
            return "FTN";
        }
        // 分支 e：同业客户且境外
        if (ClientType.VALUE_300 == clientType && "N".equals(inlandOffshore)) {
            return "FTU";
        }
        // SPEC 分支 a-e 未覆盖的输入组合无返回值定义；输出 acctNatureNo 为非必填，未命中分支即无值。
        // 该空值策略缺失已作为阻断缺口记录于 outputs/测试用例.md（阻断缺口 1-4），待需求方补充 SPEC 定义。
        return null;
    }
}
