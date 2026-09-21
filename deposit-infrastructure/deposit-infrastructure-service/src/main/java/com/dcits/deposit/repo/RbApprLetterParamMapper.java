package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbApprLetterParam;
import com.dcits.deposit.entity.RbApprLetterParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbApprLetterParamMapper {
    long countByExample(RbApprLetterParamExample example);

    int deleteByExample(RbApprLetterParamExample example);

    int deleteByPrimaryKey(@Param("paraKey") String paraKey);

    int insert(RbApprLetterParam row);

    int insertSelective(RbApprLetterParam row);

    List<RbApprLetterParam> selectByExample(RbApprLetterParamExample example);

    RbApprLetterParam selectByPrimaryKey(@Param("paraKey") String paraKey);

    int updateByExampleSelective(@Param("row") RbApprLetterParam row, @Param("example") RbApprLetterParamExample example);

    int updateByExample(@Param("row") RbApprLetterParam row, @Param("example") RbApprLetterParamExample example);

    int updateByPrimaryKeySelective(RbApprLetterParam row);

    int updateByPrimaryKey(RbApprLetterParam row);
}