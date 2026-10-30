package com.dcits.deposit.repo;

import com.dcits.deposit.entity.MbProdDefine;
import com.dcits.deposit.entity.MbProdDefineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbProdDefineMapper {
    long countByExample(MbProdDefineExample example);

    int deleteByExample(MbProdDefineExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("prodNo") String prodNo);

    int insert(MbProdDefine row);

    int insertSelective(MbProdDefine row);

    List<MbProdDefine> selectByExample(MbProdDefineExample example);

    MbProdDefine selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("prodNo") String prodNo);

    int updateByExampleSelective(@Param("row") MbProdDefine row, @Param("example") MbProdDefineExample example);

    int updateByExample(@Param("row") MbProdDefine row, @Param("example") MbProdDefineExample example);

    int updateByPrimaryKeySelective(MbProdDefine row);

    int updateByPrimaryKey(MbProdDefine row);
}