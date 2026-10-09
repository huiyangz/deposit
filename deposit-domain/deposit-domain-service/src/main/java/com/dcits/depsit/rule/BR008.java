package com.dcits.depsit.rule;

import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.ClientType;
import com.dcits.depsit.enums.TaxResidentFlag;

/**
 * BR008 设置自贸区种类（断言类规则）。
 *
 * <p>依据对私客户标志、税收居民标识、客户类型、境内境外标志确定账户属性（自贸区种类），
 * 并以账户属性取值作为返回值返回。</p>
 *
 * <p>判定分支：</p>
 * <ul>
 *   <li>分支 a、b：{@code isIndividual} 为 "Y-个人" 时，仅依据 {@code taxResidentFlag} 判定：
 *       为 "1" 或 "3" 返回 "3605"（FTI），为 "2" 返回 "3606"（FTF）；不受 {@code inlandOffshore} 影响。</li>
 *   <li>分支 c、d：{@code clientType} 为 "200-对公" 时，仅依据 {@code inlandOffshore} 判定：
 *       为 "Y" 返回 "3603"（FTE），为 "N" 返回 "3604"（FTN）；不受 {@code taxResidentFlag} 影响。</li>
 *   <li>分支 e：{@code clientType} 为 "300-同业" 且 {@code inlandOffshore} 为 "N" 时返回 "3607"（FTU）。</li>
 *   <li>分支 f：以上条件均不满足时不设置自贸区种类，返回 {@code null}。</li>
 * </ul>
 *
 * <p>各分支按其自身条件逐条判定；同一输入同时满足多条分支条件时的判定顺序源需求未规定，
 * 本规则不对此类组合约定结果。</p>
 */
public class BR008 {

    /** 对私客户标志的判定值：Y-个人。 */
    private static final String IS_INDIVIDUAL_Y = "Y";

    /** 境内境外标志：Y-境内。 */
    private static final String INLAND_OFFSHORE_Y = "Y";

    /** 境内境外标志：N-境外。 */
    private static final String INLAND_OFFSHORE_N = "N";

    /**
     * 执行规则。
     *
     * @param isIndividual    对私客户标志，判定值 "Y"（Y-个人）
     * @param taxResidentFlag 税收居民标识：1-中国税收居民，2-非中国税收居民，3-既是中国税收居民又是其他国家（地区）税收居民
     * @param clientType      客户类型：200-对公，300-同业
     * @param inlandOffshore  境内境外标志：Y-境内，N-境外
     * @return 账户属性（自贸区种类）取值 "3603"/"3604"/"3605"/"3606"/"3607"；
     *         判定条件 a～e 均不满足（分支 f）时不设置该取值，返回 {@code null}
     */
    public static String execute(String isIndividual, TaxResidentFlag taxResidentFlag,
            ClientType clientType, String inlandOffshore) {
        if (IS_INDIVIDUAL_Y.equals(isIndividual)) {
            // 分支 a、b：个人客户，仅依据税收居民标识判定，不含境内境外标志
            if (TaxResidentFlag.VALUE_1 == taxResidentFlag || TaxResidentFlag.VALUE_3 == taxResidentFlag) {
                return AcctNatureNo.VALUE_3605.getValue();
            }
            if (TaxResidentFlag.VALUE_2 == taxResidentFlag) {
                return AcctNatureNo.VALUE_3606.getValue();
            }
        }
        if (ClientType.VALUE_200 == clientType) {
            // 分支 c、d：对公客户，仅依据境内境外标志判定，不含税收居民标识
            if (INLAND_OFFSHORE_Y.equals(inlandOffshore)) {
                return AcctNatureNo.VALUE_3603.getValue();
            }
            if (INLAND_OFFSHORE_N.equals(inlandOffshore)) {
                return AcctNatureNo.VALUE_3604.getValue();
            }
        }
        if (ClientType.VALUE_300 == clientType && INLAND_OFFSHORE_N.equals(inlandOffshore)) {
            // 分支 e：同业客户且境外
            return AcctNatureNo.VALUE_3607.getValue();
        }
        // 分支 f：以上条件均不满足，不设置自贸区种类
        return null;
    }
}
