package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST100InputBO;
import com.dcits.depsit.facade.bo.ST100OutputBO;

/**
 * ST100 检查黑名单 步骤接口。
 *
 * <p>本步骤为只读检查：不写入、更新或删除任何数据，也不产生跨组件调用与消息投递。
 * 执行过程无业务失败分支（「通过」「拒绝」「授权」「提醒」均为正常完成的检查结果）；
 * 底层数据访问的技术异常向外传播，由调用方统一处理。</p>
 */
public interface IST100 {

    /**
     * 执行检查黑名单。
     *
     * @param input 步骤输入，字段见 {@link ST100InputBO}
     * @return 步骤输出；检查结果经 {@code dealFlow} 交付，检查结果为「通过」时该字段无值
     */
    ST100OutputBO execute(ST100InputBO input);
}
