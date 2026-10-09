package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST064InputBO;
import com.dcits.depsit.facade.bo.ST064OutputBO;

/**
 * ST064 检查现金支取交易权限 —— 步骤接口。
 *
 * <p>本步骤先按入参交易类型查询【交易类型定义表(RB_TRAN_DEF)】取得借贷标志、现金交易标志与
 * 冲正交易标志并产出为输出字段，再以同一次查询所得的三个标志判定该笔交易是否属于现金支取：
 * 借贷标志为「D借方」且现金交易标志为「Y是」且冲正交易标志为「N否」时产出错误码 {@code ER0070}，
 * 任一条件不成立时产出检查结果为「通过」，两项产出互斥。</p>
 *
 * <p>本步骤「状态性」为只读：只查询与判定，不新增、修改或删除任何数据，
 * 不写入本地库，调用方无需为其开启事务（无 {@code @Transactional} 要求）。</p>
 */
public interface IST064 {

    /**
     * 执行现金支取交易权限检查。
     *
     * @param input 输入 BO，{@code tranType} 必填，用于查询【交易类型定义】的键
     * @return 输出 BO；{@code crDrInd}／{@code cashTranFlag}／{@code reversal} 为查得的对应标志值，
     *         三条件同时成立时 {@code succeed=false} 且 {@code errorCode="ER0070"}，
     *         否则 {@code succeed=true} 且错误字段为 null（检查结果为「通过」）
     */
    ST064OutputBO execute(ST064InputBO input);
}
