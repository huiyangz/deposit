package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbApprLetterSub;
import com.dcits.deposit.entity.RbApprLetterSubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbApprLetterSubMapper {
    long countByExample(RbApprLetterSubExample example);

    int deleteByExample(RbApprLetterSubExample example);

    int deleteByPrimaryKey(@Param("apprLetterNo") String apprLetterNo, @Param("mainSubInd") String mainSubInd, @Param("ccy") String ccy, @Param("clientNo") String clientNo);

    int insert(RbApprLetterSub row);

    int insertSelective(RbApprLetterSub row);

    List<RbApprLetterSub> selectByExample(RbApprLetterSubExample example);

    RbApprLetterSub selectByPrimaryKey(@Param("apprLetterNo") String apprLetterNo, @Param("mainSubInd") String mainSubInd, @Param("ccy") String ccy, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbApprLetterSub row, @Param("example") RbApprLetterSubExample example);

    int updateByExample(@Param("row") RbApprLetterSub row, @Param("example") RbApprLetterSubExample example);

    int updateByPrimaryKeySelective(RbApprLetterSub row);

    int updateByPrimaryKey(RbApprLetterSub row);
}