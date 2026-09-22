package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbApprLetterTranHist;
import com.dcits.deposit.entity.RbApprLetterTranHistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbApprLetterTranHistMapper {
    long countByExample(RbApprLetterTranHistExample example);

    int deleteByExample(RbApprLetterTranHistExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int insert(RbApprLetterTranHist row);

    int insertSelective(RbApprLetterTranHist row);

    List<RbApprLetterTranHist> selectByExample(RbApprLetterTranHistExample example);

    RbApprLetterTranHist selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbApprLetterTranHist row, @Param("example") RbApprLetterTranHistExample example);

    int updateByExample(@Param("row") RbApprLetterTranHist row, @Param("example") RbApprLetterTranHistExample example);

    int updateByPrimaryKeySelective(RbApprLetterTranHist row);

    int updateByPrimaryKey(RbApprLetterTranHist row);
}