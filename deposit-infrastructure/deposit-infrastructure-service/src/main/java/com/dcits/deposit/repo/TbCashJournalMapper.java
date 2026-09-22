package com.dcits.deposit.repo;

import com.dcits.deposit.entity.TbCashJournal;
import com.dcits.deposit.entity.TbCashJournalExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCashJournalMapper {
    long countByExample(TbCashJournalExample example);

    int deleteByExample(TbCashJournalExample example);

    int deleteByPrimaryKey(@Param("journalId") String journalId, @Param("tranDate") Date tranDate);

    int insert(TbCashJournal row);

    int insertSelective(TbCashJournal row);

    List<TbCashJournal> selectByExample(TbCashJournalExample example);

    TbCashJournal selectByPrimaryKey(@Param("journalId") String journalId, @Param("tranDate") Date tranDate);

    int updateByExampleSelective(@Param("row") TbCashJournal row, @Param("example") TbCashJournalExample example);

    int updateByExample(@Param("row") TbCashJournal row, @Param("example") TbCashJournalExample example);

    int updateByPrimaryKeySelective(TbCashJournal row);

    int updateByPrimaryKey(TbCashJournal row);
}