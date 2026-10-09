package com.dcits.depsit.step;

import org.springframework.stereotype.Service;

import com.dcits.depsit.enums.CrDrInd;
import com.dcits.depsit.facade.bo.ST059InputBO;
import com.dcits.depsit.facade.bo.ST059OutputBO;

/**
 * ST059 设置借记交易的借贷标志 步骤实现。
 *
 * <p>对应正式 Spec REQ-001：执行本步骤时把借贷标志（{@code crDrInd}）赋值为“D-借方”，即枚举
 * {@link CrDrInd#D}（代码值 "D"，含义「借」）。该赋值为常量赋值，源需求未给出任何条件、分支或输入，
 * 赋值结果不依赖任何外部取值，也不存在其它候选取值。</p>
 *
 * <p>按 Spec「依赖与执行形态」：本步骤无输入、无 BCC / Mapper / 数据库 / 外部接口调用，不查询也不加载
 * 任何数据，无状态且除该赋值外不产生其它副作用。按 REQ-003 本步骤不定义业务失败场景，不返回业务失败
 * 结果、不使用错误码表达失败；执行期间发生的技术异常按技术路径向外传播，本实现不捕获、不包装、不转换。</p>
 */
@Service
public class ST059Pbc implements IST059 {

    /**
     * 执行「设置借记交易的借贷标志」步骤：把借贷标志无条件赋值为借方。
     *
     * @param input 步骤输入，本步骤不读取任何入参
     * @return 步骤输出，{@code crDrInd} 为 {@link CrDrInd#D}
     */
    @Override
    public ST059OutputBO execute(ST059InputBO input) {
        ST059OutputBO output = new ST059OutputBO();

        // 赋值借贷标志为“D-借方”：常量赋值，无分支、无输入依赖。
        output.setCrDrInd(CrDrInd.D);

        // 正常完成：设置成功标志，错误码与错误信息保持 null。
        output.setSucceed(true);
        return output;
    }
}
