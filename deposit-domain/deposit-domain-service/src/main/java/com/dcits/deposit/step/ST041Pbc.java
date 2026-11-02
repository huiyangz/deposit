package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST041InputBO;
import com.dcits.deposit.facade.bo.ST041OutputBO;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST041 处理限额。
 *
 * <p>以必填输入 limitSceneNo（限额场景编码）查询【限额控制配置】（RB_LIMIT_CTRL_CONF），
 * 取得对应配置记录的处理方式（dealFlow），并按处理方式（拒绝/提醒/授权）返回检查结果。
 * 本步骤无已确认的业务失败场景，正常完成时 succeed=true 且错误字段为空。</p>
 *
 * <p>配置记录定位方式（TBD-1）待业务确认：限额控制配置主键含限额机构编码而需求仅声明
 * 输入 limitSceneNo，本批按测试用例暂选仅按输入的 limitSceneNo 构造查询 EO 经
 * {@link IRbLimitCtrlConfBcc#findByEo} 查询并取结果集首条；查询无记录、处理方式为空、
 * limitSceneNo 未提供等情形待业务确认，见 {@link #execute(ST041InputBO)} 中 FIXME。</p>
 */
@Service
public class ST041Pbc implements IST041 {

    /** 限额控制配置（RB_LIMIT_CTRL_CONF）数据服务接口 */
    private final IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    public ST041Pbc(IRbLimitCtrlConfBcc rbLimitCtrlConfBcc) {
        this.rbLimitCtrlConfBcc = rbLimitCtrlConfBcc;
    }

    @Override
    public ST041OutputBO execute(ST041InputBO input) {
        ST041OutputBO output = new ST041OutputBO();

        // 步骤描述条目 1：按限额场景编码查询限额控制配置，取得处理方式
        // TBD-1 待确认：主键含限额机构编码而需求仅声明输入 limitSceneNo，本批暂按仅有的 limitSceneNo 构造查询 EO 经 findByEo 查询并取结果集首条
                                                                                                                                                                                                                                                                                                                                          
                                                                                                                                                                                                                
                                                           
                                                           
        RbLimitCtrlConfEO query = new RbLimitCtrlConfEO();
        query.setLimitSceneNo(input.getLimitSceneNo());
        List<RbLimitCtrlConfEO> confList = rbLimitCtrlConfBcc.findByEo(query);

        // 步骤描述条目 2：按处理方式（拒绝/提醒/授权）返回检查结果，三个分支互斥
        if (confList == null || confList.isEmpty()) {
                                                                                                                                                                                                            
                                                           
        } else {
            // 多条命中时按本项目约定取结果集第一条（Spec TBD-1 未约定唯一命中规则）
            RbLimitCtrlConfEO conf = confList.get(0);
            output.setDealFlow(conf.getDealFlow());
            if (conf.getDealFlow() == null) {
                                                                                                                                                                                       
                                                               
            }
        }

        // 正常完成：处理方式为拒绝/提醒/授权时输出对应枚举并返回成功
        output.setSucceed(true);
        output.setErrorCode(null);
        output.setErrorMessage(null);
        return output;
    }
}
