package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.PasswordStatus;
import com.dcits.deposit.facade.bo.ST011InputBO;
import com.dcits.deposit.facade.bo.ST011OutputBO;
import com.dcits.deposit.facade.components.IRbBusPasswordBcc;
import com.dcits.deposit.facade.eo.RbBusPasswordEO;

/**
 * ST011 检查支取密码状态 步骤实现。
 *
 * <p>正式 Spec REQ-001~REQ-003：依据必填输入 baseAcctNo、pwdType 查询对公账户密码表
 * （RB_BUS_PASSWORD）取得密码状态作为输出 passwordStatus；密码状态为「L-锁定」
 * （{@code PasswordStatus.L}）时以业务失败结束并返回错误码 ER0079、失败短路；否则正常完成
 * 并输出 passwordStatus，流程随后跳转至步骤《验证密码》（跳转由流程编排/步骤框架执行，
 * 本 Spec 不定义路由值）。</p>
 *
 * <p>未决内容（正式 Spec「待确认事项」）：「支取密码」对应 PwdType 枚举取值（TBD-1）、
 * 账号→账户内部键值及密码键值来源（TBD-2）、查询无记录/多条记录行为（TBD-3）、必填输入缺失
 * 行为（TBD-4）、ER0079 业务说明文本（TBD-5），见 {@link #execute(ST011InputBO)} 中 FIXME。</p>
 */
@Service
public class ST011Pbc implements IST011 {
    @Autowired
    private IRbBusPasswordBcc rbBusPasswordBcc;

    @Override
    public ST011OutputBO execute(ST011InputBO input) {
        ST011OutputBO output = new ST011OutputBO();
                                                                                                                                                                                            

        // 子步骤 1（获取密码状态）：依据必填输入 baseAcctNo、pwdType 查询对公账户密码表（RB_BUS_PASSWORD）取得密码状态
                                                           
        RbBusPasswordEO query = new RbBusPasswordEO();
        // 查询密码类型取自输入 pwdType
        query.setPwdType(input.getPwdType());
                                                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                                         
                                                           
                                                           
        List<RbBusPasswordEO> records = rbBusPasswordBcc.findByEo(query);
        // 面向单条结果的查询：无记录按「未约定则返回空」处理，多条统一取结果集第一条（本项目约定）
                                                                                                                                                                                                                          
                                                           
        if (records.isEmpty()) {
            // 无记录路径：行为待确认（TBD-3），按本项目单条结果查询约定「未约定则返回空」处理，输出无密码状态
            output.setSucceed(true);
            return output;
        }
        RbBusPasswordEO record = records.get(0);
        PasswordStatus passwordStatus = record.getPasswordStatus();
        output.setPasswordStatus(passwordStatus);
        // 子步骤 2（检查密码状态）：密码状态为「L-锁定」时以业务失败结束并返回错误码 ER0079、失败短路
        if (passwordStatus == PasswordStatus.L) {
            output.setSucceed(false);
                                                               
            output.setErrorCode("ER0079");
                                                                                                                                                                                                                               
            return output;
        }
        // 密码状态非「锁定」时正常完成并输出 passwordStatus，流程随后跳转至步骤《验证密码》（由流程编排/步骤框架执行）
        output.setSucceed(true);
        return output;
    }
}
