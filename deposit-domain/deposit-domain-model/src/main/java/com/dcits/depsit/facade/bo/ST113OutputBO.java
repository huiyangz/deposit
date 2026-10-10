package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST113 检查有权机关冻结限制 输出 BO。
 *
 * <p>业务输出仅「有权机关冻结标志」（`ahBuFlag`，`java.lang.String`，源需求标记「非必填」）。
 * 命中路径取【限制类型表】该配置 `$有权机关冻结标志$` 的原样取值；三条未命中路径
 * （查无 A-生效 记录、该限制类型无 A-生效 配置、全部记录均不表示）保持不赋值（null），
 * 不填充默认值或折算取值（Spec REQ-007）。</p>
 */
public class ST113OutputBO extends StepResult {

    /** 有权机关冻结标志 */
    private String ahBuFlag;

    public String getAhBuFlag() {
        return ahBuFlag;
    }

    public void setAhBuFlag(String ahBuFlag) {
        this.ahBuFlag = ahBuFlag;
    }
}
