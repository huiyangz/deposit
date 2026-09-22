package com.dcits.deposit.repo;

import com.dcits.deposit.entity.MbProdDefine;
import com.dcits.deposit.entity.MbProdDefineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbProdDefineMapper {
    long countByExample(MbProdDefineExample example);

    int deleteByExample(MbProdDefineExample example);

    int deleteByPrimaryKey(@Param("prodType") String prodType, @Param("seqNo") String seqNo, @Param("company") String company);

    int insert(MbProdDefine row);

    int insertSelective(MbProdDefine row);

    List<MbProdDefine> selectByExample(MbProdDefineExample example);

    MbProdDefine selectByPrimaryKey(@Param("prodType") String prodType, @Param("seqNo") String seqNo, @Param("company") String company);

    int updateByExampleSelective(@Param("row") MbProdDefine row, @Param("example") MbProdDefineExample example);

    int updateByExample(@Param("row") MbProdDefine row, @Param("example") MbProdDefineExample example);

    int updateByPrimaryKeySelective(MbProdDefine row);

    int updateByPrimaryKey(MbProdDefine row);
}