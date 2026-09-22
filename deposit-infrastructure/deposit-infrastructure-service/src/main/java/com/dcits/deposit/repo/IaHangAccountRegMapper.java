package com.dcits.deposit.repo;

import com.dcits.deposit.entity.IaHangAccountReg;
import com.dcits.deposit.entity.IaHangAccountRegExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IaHangAccountRegMapper {
    long countByExample(IaHangAccountRegExample example);

    int deleteByExample(IaHangAccountRegExample example);

    int deleteByPrimaryKey(@Param("hangSeqNo") String hangSeqNo, @Param("subHangSeqNo") String subHangSeqNo, @Param("clientNo") String clientNo);

    int insert(IaHangAccountReg row);

    int insertSelective(IaHangAccountReg row);

    List<IaHangAccountReg> selectByExample(IaHangAccountRegExample example);

    IaHangAccountReg selectByPrimaryKey(@Param("hangSeqNo") String hangSeqNo, @Param("subHangSeqNo") String subHangSeqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") IaHangAccountReg row, @Param("example") IaHangAccountRegExample example);

    int updateByExample(@Param("row") IaHangAccountReg row, @Param("example") IaHangAccountRegExample example);

    int updateByPrimaryKeySelective(IaHangAccountReg row);

    int updateByPrimaryKey(IaHangAccountReg row);
}