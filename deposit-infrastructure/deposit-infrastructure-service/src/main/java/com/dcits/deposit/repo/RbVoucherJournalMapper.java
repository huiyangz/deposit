package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbVoucherJournal;
import com.dcits.deposit.entity.RbVoucherJournalExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbVoucherJournalMapper {
    long countByExample(RbVoucherJournalExample example);

    int deleteByExample(RbVoucherJournalExample example);

    int deleteByPrimaryKey(@Param("voucherJournalId") String voucherJournalId, @Param("clientNo") String clientNo, @Param("tranDate") Date tranDate);

    int insert(RbVoucherJournal row);

    int insertSelective(RbVoucherJournal row);

    List<RbVoucherJournal> selectByExample(RbVoucherJournalExample example);

    RbVoucherJournal selectByPrimaryKey(@Param("voucherJournalId") String voucherJournalId, @Param("clientNo") String clientNo, @Param("tranDate") Date tranDate);

    int updateByExampleSelective(@Param("row") RbVoucherJournal row, @Param("example") RbVoucherJournalExample example);

    int updateByExample(@Param("row") RbVoucherJournal row, @Param("example") RbVoucherJournalExample example);

    int updateByPrimaryKeySelective(RbVoucherJournal row);

    int updateByPrimaryKey(RbVoucherJournal row);
}