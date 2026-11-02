package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST024InputBO;
import com.dcits.deposit.facade.bo.ST024OutputBO;

/**
 * ST024 检查法人透支金额 步骤接口。
 */
public interface IST024 {

	/**
	 * 执行检查法人透支金额步骤。
	 *
	 * <p>按 Spec 步骤描述 1–7 顺序执行：查询对公透支签约表获取靠档跨月季标识并赋值
	 * 靠档计息跨月跨季标志；按该标志查询法人透支白名单参数表获取并检查单笔透支检查金额；
	 * 调用贷款组件《计算账号当日放款金额合计》获取当日累计透支额度；按该标志查询白名单表
	 * 获取同一支付对象当日累计透支金额并检查；全部检查通过后跳转至《检查分行法人透支额度》。</p>
	 *
	 * @param input 输入：baseAcctNo 账号、tranAmt 交易金额
	 * @return 输出；正常完成时 succeed=true，业务失败时 succeed=false 并携带已确认错误码
	 */
	ST024OutputBO execute(ST024InputBO input);
}
