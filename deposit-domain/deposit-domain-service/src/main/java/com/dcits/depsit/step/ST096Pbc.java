package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST096InputBO;
import com.dcits.depsit.facade.bo.ST096OutputBO;
import org.springframework.stereotype.Service;

/**
 * ST096 设置账户执行利率 步骤实现（交易执行步骤）。
 *
 * <p>唯一业务动作：赋值账户$执行利率$为[执行利率]（源需求「## 步骤描述」1），即把入参
 * {@code realRate} 的取值设置为账户的执行利率属性，并以输出字段 {@code realRate} 返回该取值
 * （REQ-001、REQ-002）。该赋值为<b>无条件执行</b>：不依赖任何取值判定，直接覆盖赋值前的既有取值，
 * 而非「为空才设置」的条件赋值；取值原值传递，不做取整、舍入或按标度缩放（Spec 不覆盖事项 4）。</p>
 *
 * <p>本步骤无子步骤、无分支与循环，不查询任何实体、不调用 BCC／Mapper／数据库／外部接口／其它组件步骤，
 * 也不产生本地写入，故实现不注入任何依赖，{@code execute} 亦不使用 {@code @Transactional}。</p>
 *
 * <p>赋值目标的落库实体、字段与主键定位口径源需求输入、输出表「来源实体」列均为空、未声明
 * （Spec 不覆盖事项 1），本实现不据此指定落库位置：赋值结果经输出字段 {@code realRate} 承载并原样返回，
 * 待该口径经业务确认后随 REQ-001 一并补充落库写入。</p>
 *
 * <p>正常完成时设置 {@code succeed = true}，错误码与错误信息保持 {@code null}。源需求「## 失败处理」声明
 * 本步骤无业务失败场景，失败仅由技术异常按工程既有方式向上传播，实现不捕获异常、不返回兜底取值。
 * 源需求未定义 {@code realRate} 未上送或为空时的行为（Spec 不覆盖事项 2），本实现不为其制造分支。</p>
 */
@Service
public class ST096Pbc implements IST096 {

    /**
     * 执行「设置账户执行利率」：赋值账户$执行利率$为[执行利率]并返回。
     *
     * @param input 步骤输入，唯一字段 {@code realRate}（执行利率，必填）
     * @return 步骤输出，{@code realRate} 与入参 {@code realRate} 数值相同，{@code succeed} 为 {@code true}
     */
    @Override
    public ST096OutputBO execute(ST096InputBO input) {
        ST096OutputBO output = new ST096OutputBO();

        // 步骤描述 1（REQ-001）：赋值账户$执行利率$为[执行利率]；无条件赋值，直接以入参取值覆盖既有取值，
        // 落库目标源需求未声明（Spec 不覆盖事项 1），故不指定落库位置
        output.setRealRate(input.getRealRate());

        // REQ-002：输出 realRate 取值为本次设置到账户的执行利率取值，与入参一致；本步骤无分支，输出不作判定依据
        // 正常完成：succeed = true，错误码与错误信息保持 null
        output.setSucceed(true);
        return output;
    }
}
