package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbTdaHist;
import com.dcits.deposit.entity.RbTdaHistExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbTdaHistMapper {
    long countByExample(RbTdaHistExample example);

    int deleteByExample(RbTdaHistExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo, @Param("acctMovtDate") Date acctMovtDate);

    int insert(RbTdaHist row);

    int insertSelective(RbTdaHist row);

    List<RbTdaHist> selectByExample(RbTdaHistExample example);

    RbTdaHist selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo, @Param("acctMovtDate") Date acctMovtDate);

    int updateByExampleSelective(@Param("row") RbTdaHist row, @Param("example") RbTdaHistExample example);

    int updateByExample(@Param("row") RbTdaHist row, @Param("example") RbTdaHistExample example);

    int updateByPrimaryKeySelective(RbTdaHist row);

    int updateByPrimaryKey(RbTdaHist row);
}