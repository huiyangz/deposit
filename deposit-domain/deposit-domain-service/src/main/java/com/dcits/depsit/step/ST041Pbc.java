package com.dcits.depsit.step;

import org.springframework.stereotype.Service;

import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.facade.bo.ST041InputBO;
import com.dcits.depsit.facade.bo.ST041OutputBO;

/**
 * ST041 检查存入交易类型 步骤实现。
 *
 * 本步骤在活期现金存入交易场景被调用（场景本身为调用前提，本步骤不校验场景），
 * 只做一次等值判定：入参交易类型等于枚举成员「现金存入」时返回检查结果「通过」，
 * 否则返回错误码 {@code ER0049}（含义「交易类型错误」）。两项产出由同一分支互斥产出。
 *
 * 本步骤为纯入参判定，无 BCC、规则、组件内步骤、跨组件调用与数据访问，无事务要求。
 */
@Service
public class ST041Pbc implements IST041 {

    /** 判定为不通过时的错误码，来源：errorcodes.properties 的 {@code ER0049}。 */
    private static final String ERROR_CODE_TRAN_TYPE = "ER0049";

    /** 错误信息，按「错误码::业务说明」格式取错误码清单中 ER0049 的业务说明。 */
    private static final String ERROR_MESSAGE_TRAN_TYPE = "ER0049::交易类型错误";

    @Override
    public ST041OutputBO execute(ST041InputBO input) {
        ST041OutputBO output = new ST041OutputBO();

        // 判定（Spec REQ-001／REQ-002／REQ-003）：按枚举成员的代码值等值比较。
        // TranType 中以代码值 "1000" 定位的唯一成员即「现金存入」TranType.VALUE_1000，
        // 故与 VALUE_1000 等值即等价于代码值等于 "1000"，比较结果不取决于成员的注释文本。
        if (TranType.VALUE_1000.equals(input.getTranType())) {
            // 等于「现金存入」：返回检查结果「通过」，不产出错误码。
            output.setSucceed(true);
            return output;
        }
        // 不等于「现金存入」：返回错误码 ER0049，不产出检查结果「通过」。
        output.setSucceed(false);
        output.setErrorCode(ERROR_CODE_TRAN_TYPE);
        output.setErrorMessage(ERROR_MESSAGE_TRAN_TYPE);
        return output;
    }
}
