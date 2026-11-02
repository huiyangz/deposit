package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST005InputBO;
import com.dcits.deposit.facade.bo.ST005OutputBO;

/**
 * ST005 检查支取账户限额 步骤接口。
 *
 * <p>按正式 Spec ST005「步骤描述」14 条编排：匹配限额场景（ST043）、检查机构匹配的限额场景
 * 配置（ST038）、检查有效的限额场景配置（ST045）、检查限额场景编码（ST037）、获取累计限额
 * （ST042）、计算限额累计金额（ST039）、检查限额（ST040）、按累计情况分支更新（ST046）或
 * 登记（ST044）累计限额，超限时按处理方式（ST041）返回错误码 ER0058、授权标志「需授权」
 * 或检查结果「超限，但可继续交易」。未匹配、[限额场景编码]为空等检查不满足时返回检查
 * 结果「通过」并正常提前结束。</p>
 *
 * <p>事务要求：更新/登记分支会对本地数据库【限额累计信息表】（RB_LIMIT_SUM_INFO）执行
 * 写入，调用方应在事务上下文中调用；实现类 execute 已标注 Spring {@code @Transactional}。</p>
 */
public interface IST005 {

    /**
     * 检查支取账户限额。
     *
     * @param input 步骤输入（客户号、账号、因子名称、交易日期、交易时间戳、交易金额）
     * @return 步骤结果；正常完成与正常提前结束（「通过」「超限，但可继续交易」「需授权」）
     *         succeed=true 且 errorCode、errorMessage 为空；[检查结果]为「拒绝」时业务失败：
     *         succeed=false、errorCode=ER0058、errorMessage=「ER0058::交易超出限额控制」
     */
    ST005OutputBO execute(ST005InputBO input);
}
