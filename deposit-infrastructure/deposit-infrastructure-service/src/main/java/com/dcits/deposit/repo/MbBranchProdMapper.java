package com.dcits.deposit.repo;

import com.dcits.deposit.entity.MbBranchProd;
import com.dcits.deposit.entity.MbBranchProdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbBranchProdMapper {
    long countByExample(MbBranchProdExample example);

    int deleteByExample(MbBranchProdExample example);

    int deleteByPrimaryKey(@Param("branch") String branch, @Param("prodType") String prodType, @Param("company") String company);

    int insert(MbBranchProd row);

    int insertSelective(MbBranchProd row);

    List<MbBranchProd> selectByExample(MbBranchProdExample example);

    MbBranchProd selectByPrimaryKey(@Param("branch") String branch, @Param("prodType") String prodType, @Param("company") String company);

    int updateByExampleSelective(@Param("row") MbBranchProd row, @Param("example") MbBranchProdExample example);

    int updateByExample(@Param("row") MbBranchProd row, @Param("example") MbBranchProdExample example);

    int updateByPrimaryKeySelective(MbBranchProd row);

    int updateByPrimaryKey(MbBranchProd row);
}