package com.dcits.deposit.repo;

import com.dcits.deposit.entity.PtPaymentTranHist;
import com.dcits.deposit.entity.PtPaymentTranHistExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PtPaymentTranHistMapper {
    long countByExample(PtPaymentTranHistExample example);

    int deleteByExample(PtPaymentTranHistExample example);

    int deleteByPrimaryKey(@Param("channelSeqNo") String channelSeqNo, @Param("channelSubSeqNo") String channelSubSeqNo, @Param("tranDate") Date tranDate, @Param("clientNo") String clientNo);

    int insert(PtPaymentTranHist row);

    int insertSelective(PtPaymentTranHist row);

    List<PtPaymentTranHist> selectByExample(PtPaymentTranHistExample example);

    PtPaymentTranHist selectByPrimaryKey(@Param("channelSeqNo") String channelSeqNo, @Param("channelSubSeqNo") String channelSubSeqNo, @Param("tranDate") Date tranDate, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") PtPaymentTranHist row, @Param("example") PtPaymentTranHistExample example);

    int updateByExample(@Param("row") PtPaymentTranHist row, @Param("example") PtPaymentTranHistExample example);

    int updateByPrimaryKeySelective(PtPaymentTranHist row);

    int updateByPrimaryKey(PtPaymentTranHist row);
}