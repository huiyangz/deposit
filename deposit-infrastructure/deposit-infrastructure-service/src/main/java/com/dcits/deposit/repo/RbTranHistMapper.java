package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbTranHist;
import com.dcits.deposit.entity.RbTranHistExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbTranHistMapper {
    long countByExample(RbTranHistExample example);

    int deleteByExample(RbTranHistExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo, @Param("tranDate") Date tranDate);

    int insert(RbTranHist row);

    int insertSelective(RbTranHist row);

    List<RbTranHist> selectByExample(RbTranHistExample example);

    RbTranHist selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo, @Param("tranDate") Date tranDate);

    int updateByExampleSelective(@Param("row") RbTranHist row, @Param("example") RbTranHistExample example);

    int updateByExample(@Param("row") RbTranHist row, @Param("example") RbTranHistExample example);

    int updateByPrimaryKeySelective(RbTranHist row);

    int updateByPrimaryKey(RbTranHist row);
}