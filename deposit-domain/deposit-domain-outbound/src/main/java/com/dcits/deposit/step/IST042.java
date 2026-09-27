package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST042InputBO;
import com.dcits.deposit.facade.bo.ST042OutputBO;

/** ST042 检查联系人 步骤接口 */
public interface IST042 {

	/**
	 * 检查联系人：校验{证件类型}在[证件类型列表]中；居民身份证校验{证件号码}长度18位；
	 * 校验{电话号码}长度11位，通过时返回检查结果"通过"。
	 * 本步骤只读校验【证件类型定义信息】，不涉及本地数据库写入，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 检查结果输出BO
	 */
	ST042OutputBO execute(ST042InputBO input);
}
