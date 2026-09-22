package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbExchangeTranAttach;
import com.dcits.deposit.entity.RbExchangeTranAttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbExchangeTranAttachMapper {
    long countByExample(RbExchangeTranAttachExample example);

    int deleteByExample(RbExchangeTranAttachExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int insert(RbExchangeTranAttach row);

    int insertSelective(RbExchangeTranAttach row);

    List<RbExchangeTranAttach> selectByExample(RbExchangeTranAttachExample example);

    RbExchangeTranAttach selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbExchangeTranAttach row, @Param("example") RbExchangeTranAttachExample example);

    int updateByExample(@Param("row") RbExchangeTranAttach row, @Param("example") RbExchangeTranAttachExample example);

    int updateByPrimaryKeySelective(RbExchangeTranAttach row);

    int updateByPrimaryKey(RbExchangeTranAttach row);
}