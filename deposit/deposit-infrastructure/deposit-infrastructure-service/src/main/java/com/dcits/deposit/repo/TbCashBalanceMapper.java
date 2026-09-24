package com.dcits.deposit.repo;

import com.dcits.deposit.entity.TbCashBalance;
import com.dcits.deposit.entity.TbCashBalanceExample;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCashBalanceMapper {
    long countByExample(TbCashBalanceExample example);

    int deleteByExample(TbCashBalanceExample example);

    int deleteByPrimaryKey(@Param("tranTimestamp") String tranTimestamp, @Param("updateDate") Date updateDate, @Param("branch") String branch, @Param("eopdAmount") BigDecimal eopdAmount, @Param("tailboxId") String tailboxId, @Param("availableAmt") BigDecimal availableAmt, @Param("sopdAmount") BigDecimal sopdAmount, @Param("lockAmount") BigDecimal lockAmount, @Param("company") String company, @Param("amount") BigDecimal amount, @Param("ccy") String ccy, @Param("lockSpallAmt") BigDecimal lockSpallAmt, @Param("cashId") Integer cashId, @Param("lastChangeDate") Date lastChangeDate, @Param("createTimestamp") String createTimestamp);

    int insert(TbCashBalance row);

    int insertSelective(TbCashBalance row);

    List<TbCashBalance> selectByExample(TbCashBalanceExample example);

    TbCashBalance selectByPrimaryKey(@Param("tranTimestamp") String tranTimestamp, @Param("updateDate") Date updateDate, @Param("branch") String branch, @Param("eopdAmount") BigDecimal eopdAmount, @Param("tailboxId") String tailboxId, @Param("availableAmt") BigDecimal availableAmt, @Param("sopdAmount") BigDecimal sopdAmount, @Param("lockAmount") BigDecimal lockAmount, @Param("company") String company, @Param("amount") BigDecimal amount, @Param("ccy") String ccy, @Param("lockSpallAmt") BigDecimal lockSpallAmt, @Param("cashId") Integer cashId, @Param("lastChangeDate") Date lastChangeDate, @Param("createTimestamp") String createTimestamp);

    int updateByExampleSelective(@Param("row") TbCashBalance row, @Param("example") TbCashBalanceExample example);

    int updateByExample(@Param("row") TbCashBalance row, @Param("example") TbCashBalanceExample example);

    int updateByPrimaryKeySelective(TbCashBalance row);

    int updateByPrimaryKey(TbCashBalance row);
}