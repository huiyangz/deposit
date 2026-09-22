package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbExchangeTranHist;
import com.dcits.deposit.entity.RbExchangeTranHistExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbExchangeTranHistMapper {
    long countByExample(RbExchangeTranHistExample example);

    int deleteByExample(RbExchangeTranHistExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo, @Param("tranDate") Date tranDate);

    int insert(RbExchangeTranHist row);

    int insertSelective(RbExchangeTranHist row);

    List<RbExchangeTranHist> selectByExample(RbExchangeTranHistExample example);

    RbExchangeTranHist selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo, @Param("tranDate") Date tranDate);

    int updateByExampleSelective(@Param("row") RbExchangeTranHist row, @Param("example") RbExchangeTranHistExample example);

    int updateByExample(@Param("row") RbExchangeTranHist row, @Param("example") RbExchangeTranHistExample example);

    int updateByPrimaryKeySelective(RbExchangeTranHist row);

    int updateByPrimaryKey(RbExchangeTranHist row);
}