package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST009InputBO;
import com.dcits.deposit.facade.bo.ST009OutputBO;

/**
 * ST009 检查现金存入账户限制 步骤接口
 *
 * 现金存入前依次经检查限制组件《检查账户限制》任务获取账户限制信息、
 * 现金不收不付限制标志、现金止收标志、属性限制标志，并按限制优先级与豁免结果
 * 给出检查结论：通过时 succeed=true；存在现金不收不付限制、现金止收限制、
 * 限制未豁免时分别返回错误码 ER0043、ER0044、ER0045。
 * 本步骤仅调用跨组件接口，不涉及本地数据库读写，无事务要求。
 */
public interface IST009 {

	/**
	 * 检查现金存入账户限制。
	 *
	 * @param input 输入BO，baseAcctNo、tranType、channelNo、prodNo、narrativeCode 均为必填
	 * @return 检查结果：通过或“不检查限制”提前结束时 succeed=true 且错误字段为 null；
	 *         存在现金不收不付限制时 errorCode=ER0043，存在现金止收限制时 errorCode=ER0044，
	 *         限制未豁免时 errorCode=ER0045
	 */
	ST009OutputBO execute(ST009InputBO input);
}
