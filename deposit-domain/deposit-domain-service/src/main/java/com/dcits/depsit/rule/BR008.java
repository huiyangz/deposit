package com.dcits.depsit.rule;

import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.ClientType;
import com.dcits.depsit.enums.TaxResidentFlag;

/**
 * BR008 设置自贸区种类（断言类规则）。
 *
 * <p>依据客户类型、税收居民标识、境内境外标志确定账户属性（自贸区种类），
 * 并以账户属性取值作为返回值返回。</p>
 *
 * <p>判定分支：</p>
 * <ul>
 *   <li>{@code clientType} 为 "100-个人"：{@code taxResidentFlag} 为 "1" 或 "3" 返回 "3605"（FTI），
 *       为 "2" 返回 "3606"（FTF）；不受 {@code inlandOffshore} 影响。</li>
 *   <li>{@code clientType} 为 "200-对公"：{@code inlandOffshore} 为 "Y" 返回 "3603"（FTE），
 *       为 "N" 返回 "3604"（FTN）；不受 {@code taxResidentFlag} 影响。</li>
 *   <li>{@code clientType} 为 "300-同业" 且 {@code inlandOffshore} 为 "N"：返回 "3607"（FTU）。</li>
 * </ul>
 *
 * <p>{@code isIndividual}（对私客户标志）为必填入参，但规则描述各分支均未引用该字段，
 * 其取值不影响判定结果。</p>
 */
public class BR008 {

    /**
     * 执行规则。
     *
     * @param isIndividual    对私客户标志（必填，不参与判定）
     * @param taxResidentFlag 税收居民标识：1-中国税收居民，2-非中国税收居民，3-既是中国税收居民又是其他国家（地区）税收居民
     * @param clientType      客户类型：100-个人，200-对公，300-同业
     * @param inlandOffshore  境内境外标志：Y-境内，N-境外
     * @return 账户属性（自贸区种类）取值；源需求未定义判定结果的输入组合返回 {@code null}
     */
    public static String execute(String isIndividual, TaxResidentFlag taxResidentFlag,
            ClientType clientType, String inlandOffshore) {
        if (ClientType.VALUE_100 == clientType) {
            // 个人客户：仅依据税收居民标识判定
            if (TaxResidentFlag.VALUE_1 == taxResidentFlag || TaxResidentFlag.VALUE_3 == taxResidentFlag) {
                return AcctNatureNo.VALUE_3605.getValue();
            }
            if (TaxResidentFlag.VALUE_2 == taxResidentFlag) {
                return AcctNatureNo.VALUE_3606.getValue();
            }
        } else if (ClientType.VALUE_200 == clientType) {
            // 对公客户：仅依据境内境外标志判定
            if ("Y".equals(inlandOffshore)) {
                return AcctNatureNo.VALUE_3603.getValue();
            }
            if ("N".equals(inlandOffshore)) {
                return AcctNatureNo.VALUE_3604.getValue();
            }
        } else if (ClientType.VALUE_300 == clientType && "N".equals(inlandOffshore)) {
            // 同业客户：境外汇外机构自由贸易账户
            return AcctNatureNo.VALUE_3607.getValue();
        }
        return null;
    }
}
