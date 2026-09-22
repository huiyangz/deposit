package com.dcits.deposit.repo;

import com.dcits.deposit.entity.FmFtaBranch;
import com.dcits.deposit.entity.FmFtaBranchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmFtaBranchMapper {
    long countByExample(FmFtaBranchExample example);

    int deleteByExample(FmFtaBranchExample example);

    int deleteByPrimaryKey(@Param("ftaCode") String ftaCode);

    int insert(FmFtaBranch row);

    int insertSelective(FmFtaBranch row);

    List<FmFtaBranch> selectByExample(FmFtaBranchExample example);

    FmFtaBranch selectByPrimaryKey(@Param("ftaCode") String ftaCode);

    int updateByExampleSelective(@Param("row") FmFtaBranch row, @Param("example") FmFtaBranchExample example);

    int updateByExample(@Param("row") FmFtaBranch row, @Param("example") FmFtaBranchExample example);

    int updateByPrimaryKeySelective(FmFtaBranch row);

    int updateByPrimaryKey(FmFtaBranch row);
}