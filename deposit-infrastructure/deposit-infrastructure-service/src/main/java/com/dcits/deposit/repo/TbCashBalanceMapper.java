package com.dcits.deposit.repo;

import com.dcits.deposit.entity.TbCashBalance;
import com.dcits.deposit.entity.TbCashBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCashBalanceMapper {
    long countByExample(TbCashBalanceExample example);

    int deleteByExample(TbCashBalanceExample example);

    int deleteByPrimaryKey(@Param("cashId") Integer cashId);

    int insert(TbCashBalance row);

    int insertSelective(TbCashBalance row);

    List<TbCashBalance> selectByExample(TbCashBalanceExample example);

    TbCashBalance selectByPrimaryKey(@Param("cashId") Integer cashId);

    int updateByExampleSelective(@Param("row") TbCashBalance row, @Param("example") TbCashBalanceExample example);

    int updateByExample(@Param("row") TbCashBalance row, @Param("example") TbCashBalanceExample example);

    int updateByPrimaryKeySelective(TbCashBalance row);

    int updateByPrimaryKey(TbCashBalance row);
}