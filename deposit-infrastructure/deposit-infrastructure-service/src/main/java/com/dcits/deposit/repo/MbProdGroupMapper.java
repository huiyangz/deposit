package com.dcits.deposit.repo;

import com.dcits.deposit.entity.MbProdGroup;
import com.dcits.deposit.entity.MbProdGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbProdGroupMapper {
    long countByExample(MbProdGroupExample example);

    int deleteByExample(MbProdGroupExample example);

    int deleteByPrimaryKey(@Param("prodType") String prodType, @Param("prodSubType") String prodSubType, @Param("company") String company);

    int insert(MbProdGroup row);

    int insertSelective(MbProdGroup row);

    List<MbProdGroup> selectByExample(MbProdGroupExample example);

    MbProdGroup selectByPrimaryKey(@Param("prodType") String prodType, @Param("prodSubType") String prodSubType, @Param("company") String company);

    int updateByExampleSelective(@Param("row") MbProdGroup row, @Param("example") MbProdGroupExample example);

    int updateByExample(@Param("row") MbProdGroup row, @Param("example") MbProdGroupExample example);

    int updateByPrimaryKeySelective(MbProdGroup row);

    int updateByPrimaryKey(MbProdGroup row);
}