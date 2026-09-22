package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbDelayTranHist;
import com.dcits.deposit.entity.RbDelayTranHistExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbDelayTranHistMapper {
    long countByExample(RbDelayTranHistExample example);

    int deleteByExample(RbDelayTranHistExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo, @Param("tranDate") Date tranDate);

    int insert(RbDelayTranHist row);

    int insertSelective(RbDelayTranHist row);

    List<RbDelayTranHist> selectByExample(RbDelayTranHistExample example);

    RbDelayTranHist selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo, @Param("tranDate") Date tranDate);

    int updateByExampleSelective(@Param("row") RbDelayTranHist row, @Param("example") RbDelayTranHistExample example);

    int updateByExample(@Param("row") RbDelayTranHist row, @Param("example") RbDelayTranHistExample example);

    int updateByPrimaryKeySelective(RbDelayTranHist row);

    int updateByPrimaryKey(RbDelayTranHist row);
}