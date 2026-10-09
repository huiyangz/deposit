package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST057InputBO;
import com.dcits.depsit.facade.bo.ST057OutputBO;

/**
 * ST057 检查支取交易类型 —— 步骤接口。
 *
 * <p>本步骤按入参交易类型（{@code tranType}）查询【交易类型定义表(RB_TRAN_DEF)】，取得借贷标志、
 * 现金交易标志与冲正交易标志并分别产出为 {@code crDrInd}、{@code cashTranFlag}、{@code reversal}；
 * 再以同一次查询所得的这三个标志判定该交易类型是否为支取类交易：借贷标志为「D-借方」且
 * 现金交易标志为「Y是」且冲正交易标志为「N否」三项同时成立时继续执行（{@code succeed=true}、
 * 错误字段为 null），任一条件不成立时返回错误码 {@code ER0067}（{@code succeed=false}），
 * 两类结果由同一判定互斥产出。</p>
 *
 * <p>本步骤为检查步骤，只查询与判定，不新增、修改或删除任何数据，不发起其它 BCC、Mapper、
 * 数据库或组件调用，故调用方无需为其开启事务（无 {@code @Transactional} 要求）。</p>
 */
public interface IST057 {

    /**
     * 执行支取交易类型检查。
     *
     * @param input 输入 BO，{@code tranType} 必填，为查询【交易类型定义】的键
     * @return 输出 BO；{@code crDrInd}／{@code cashTranFlag}／{@code reversal} 为同一次查询所得记录的
     *         对应标志值，三条件同时成立时 {@code succeed=true} 且两个错误字段为 null，
     *         否则 {@code succeed=false} 且 {@code errorCode="ER0067"}
     */
    ST057OutputBO execute(ST057InputBO input);
}
