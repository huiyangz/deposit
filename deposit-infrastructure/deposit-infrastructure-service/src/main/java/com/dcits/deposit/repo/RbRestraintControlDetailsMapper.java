package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbRestraintControlDetails;
import com.dcits.deposit.entity.RbRestraintControlDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbRestraintControlDetailsMapper {
    long countByExample(RbRestraintControlDetailsExample example);

    int deleteByExample(RbRestraintControlDetailsExample example);

    int deleteByPrimaryKey(@Param("restraintType") String restraintType, @Param("prodType") String prodType, @Param("tranTypeLink") String tranTypeLink, @Param("batchFlag") String batchFlag, @Param("resBranchRange") String resBranchRange, @Param("counterFlag") String counterFlag);

    int insert(RbRestraintControlDetails row);

    int insertSelective(RbRestraintControlDetails row);

    List<RbRestraintControlDetails> selectByExample(RbRestraintControlDetailsExample example);

    RbRestraintControlDetails selectByPrimaryKey(@Param("restraintType") String restraintType, @Param("prodType") String prodType, @Param("tranTypeLink") String tranTypeLink, @Param("batchFlag") String batchFlag, @Param("resBranchRange") String resBranchRange, @Param("counterFlag") String counterFlag);

    int updateByExampleSelective(@Param("row") RbRestraintControlDetails row, @Param("example") RbRestraintControlDetailsExample example);

    int updateByExample(@Param("row") RbRestraintControlDetails row, @Param("example") RbRestraintControlDetailsExample example);

    int updateByPrimaryKeySelective(RbRestraintControlDetails row);

    int updateByPrimaryKey(RbRestraintControlDetails row);
}