package com.dcits;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 既定外部接口 mock：按建模定案《外部接口清单_建立对公存款合约》实现的既定外部系统接口。
 * 非平台外部系统当前未提供真实服务，由本 mock 提供固定返回，便于组件联调。
 */
@RestController
public class MockExternalTask {

	private static final Logger logger = LoggerFactory.getLogger(MockExternalTask.class);

	/**
	 * 贷款《计算账号当日放款金额合计》：按账号返回当日累计透支额度。
	 * 贷款组件不提供真实口径，按约定直接返回固定值 0.00。
	 */
	@GetMapping("/loan/calcAcctDailyLoanAmt")
	public Map<String, Object> calcAcctDailyLoanAmt(@RequestParam("acctNo") String acctNo) {
		logger.debug("计算账号当日放款金额合计：acctNo={}", acctNo);
		return Map.of("dailyOverdraftAmt", "0.00");
	}

}
