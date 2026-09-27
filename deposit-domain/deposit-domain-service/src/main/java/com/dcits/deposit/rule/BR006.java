package com.dcits.deposit.rule;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.TaxResidentFlag;

/**
 * 设置自贸区种类
 *
 * 决策类规则：根据客户类型、对私客户标志、税收居民标识、境内境外标志设置账户的自贸区种类（账户属性）。
 */
public class BR006 {

	/** 对私客户标志比较字面：Y-个人（按 SPEC 整串字面比较） */
	private static final String IS_INDIVIDUAL_PERSONAL = "Y-个人";

	/** 境内境外标志比较字面：Y-境内 */
	private static final String INLAND = "Y-境内";

	/** 境内境外标志比较字面：N-境外 */
	private static final String OFFSHORE = "N-境外";

	/**
	 * 设置自贸区种类
	 *
	 * @param isIndividual 对私客户标志
	 * @param taxResidentFlag 税收居民标识
	 * @param clientType 客户类型
	 * @param inlandOffshore 境内境外标志
	 * @return acctNatureNo 自贸区种类（账户属性）；无决策条目命中时 SPEC 未定义返回值，按非必填输出返回 null
	 */
	public static AcctNatureNo execute(String isIndividual, TaxResidentFlag taxResidentFlag, ClientType clientType,
			String inlandOffshore) {
		// a.客户类型=100-个人 且 对私客户标志=Y-个人 且 税收居民标识=1-中国税收居民 或 3-既是中国税收居民又是其他国家（地区）税收居民
		if (clientType == ClientType.VALUE_100
				&& IS_INDIVIDUAL_PERSONAL.equals(isIndividual)
				&& (taxResidentFlag == TaxResidentFlag.VALUE_1 || taxResidentFlag == TaxResidentFlag.VALUE_3)) {
			return AcctNatureNo.VALUE_3605; // FTI-区内个人自由贸易账户
		}
		// b.客户类型=100-个人 且 税收居民标识=2-非中国税收居民
		if (clientType == ClientType.VALUE_100
				&& taxResidentFlag == TaxResidentFlag.VALUE_2) {
			return AcctNatureNo.VALUE_3606; // FTF-区内境外个人自由贸易账户
		}
		// c.客户类型=200-对公 且 境内境外标志=Y-境内
		if (clientType == ClientType.VALUE_200
				&& INLAND.equals(inlandOffshore)) {
			return AcctNatureNo.VALUE_3603; // FTE-区内机构自由贸易账户
		}
		// d.客户类型=200-对公 且 境内境外标志=N-境外
		if (clientType == ClientType.VALUE_200
				&& OFFSHORE.equals(inlandOffshore)) {
			return AcctNatureNo.VALUE_3604; // FTN-境外机构自由贸易账户
		}
		// e.客户类型=300-同业 且 境内境外标志=N-境外
		if (clientType == ClientType.VALUE_300
				&& OFFSHORE.equals(inlandOffshore)) {
			return AcctNatureNo.VALUE_3607; // FTU-同业机构自由贸易账户
		}
		return null;
	}
}
