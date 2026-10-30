package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RcAllList;
import com.dcits.deposit.entity.RcAllListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RcAllListMapper {
    long countByExample(RcAllListExample example);

    int deleteByExample(RcAllListExample example);

    int deleteByPrimaryKey(@Param("rcSeqNo") String rcSeqNo);

    int insert(RcAllList row);

    int insertSelective(RcAllList row);

    List<RcAllList> selectByExample(RcAllListExample example);

    RcAllList selectByPrimaryKey(@Param("rcSeqNo") String rcSeqNo);

    int updateByExampleSelective(@Param("row") RcAllList row, @Param("example") RcAllListExample example);

    int updateByExample(@Param("row") RcAllList row, @Param("example") RcAllListExample example);

    int updateByPrimaryKeySelective(RcAllList row);

    int updateByPrimaryKey(RcAllList row);
}