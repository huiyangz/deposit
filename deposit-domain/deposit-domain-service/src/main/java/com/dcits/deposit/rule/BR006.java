package com.dcits.deposit.rule;

import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.TaxResidentFlag;

/**
 * 设置自贸区种类
 *
 * 规则类型：决策类
 */
public class BR006 {

	/**
	 * 根据客户类型、对私客户标志、税收居民标识、境内境外标志设置自贸区种类（账户属性编号）。
	 *
	 * @param isIndividual 对私客户标志（Y-个人）
	 * @param taxResidentFlag 税收居民标识
	 * @param clientType 客户类型
	 * @param inlandOffshore 境内境外标志（Y-境内，N-境外）
	 * @return 自贸区种类（FT 字母代码 FTI/FTF/FTE/FTN/FTU），其余情况为空（null）
	 */
	public static String execute(String isIndividual, TaxResidentFlag taxResidentFlag, ClientType clientType,
			String inlandOffshore) {
		// 决策行a：100-个人 且 对私客户标志=Y 且（税收居民标识=1-中国税收居民 或 3-既是中国税收居民又是其他国家（地区）税收居民）→ FTI-区内个人自由贸易账户
		if (clientType == ClientType.VALUE_100 && "Y".equals(isIndividual)
				&& (taxResidentFlag == TaxResidentFlag.VALUE_1 || taxResidentFlag == TaxResidentFlag.VALUE_3)) {
			return "FTI";
		}
		// 决策行b：100-个人 且 税收居民标识=2-非中国税收居民 → FTF-区内境外个人自由贸易账户
		if (clientType == ClientType.VALUE_100 && taxResidentFlag == TaxResidentFlag.VALUE_2) {
			return "FTF";
		}
		// 决策行c：200-对公 且 境内境外标志=Y-境内 → FTE-区内机构自由贸易账户
		if (clientType == ClientType.VALUE_200 && "Y".equals(inlandOffshore)) {
			return "FTE";
		}
		// 决策行d：200-对公 且 境内境外标志=N-境外 → FTN-境外机构自由贸易账户
		if (clientType == ClientType.VALUE_200 && "N".equals(inlandOffshore)) {
			return "FTN";
		}
		// 决策行e：300-同业 且 境内境外标志=N-境外 → FTU-同业机构自由贸易账户
		if (clientType == ClientType.VALUE_300 && "N".equals(inlandOffshore)) {
			return "FTU";
		}
		// 决策行f：其余情况，自贸区种类为空
		return null;
	}
}
