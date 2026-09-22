package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbApprLetter;
import com.dcits.deposit.entity.RbApprLetterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbApprLetterMapper {
    long countByExample(RbApprLetterExample example);

    int deleteByExample(RbApprLetterExample example);

    int deleteByPrimaryKey(@Param("apprLetterNo") String apprLetterNo, @Param("clientNo") String clientNo);

    int insert(RbApprLetter row);

    int insertSelective(RbApprLetter row);

    List<RbApprLetter> selectByExample(RbApprLetterExample example);

    RbApprLetter selectByPrimaryKey(@Param("apprLetterNo") String apprLetterNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbApprLetter row, @Param("example") RbApprLetterExample example);

    int updateByExample(@Param("row") RbApprLetter row, @Param("example") RbApprLetterExample example);

    int updateByPrimaryKeySelective(RbApprLetter row);

    int updateByPrimaryKey(RbApprLetter row);
}