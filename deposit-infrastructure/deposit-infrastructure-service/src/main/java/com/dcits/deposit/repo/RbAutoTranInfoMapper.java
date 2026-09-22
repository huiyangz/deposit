package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAutoTranInfo;
import com.dcits.deposit.entity.RbAutoTranInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAutoTranInfoMapper {
    long countByExample(RbAutoTranInfoExample example);

    int deleteByExample(RbAutoTranInfoExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int insert(RbAutoTranInfo row);

    int insertSelective(RbAutoTranInfo row);

    List<RbAutoTranInfo> selectByExample(RbAutoTranInfoExample example);

    RbAutoTranInfo selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAutoTranInfo row, @Param("example") RbAutoTranInfoExample example);

    int updateByExample(@Param("row") RbAutoTranInfo row, @Param("example") RbAutoTranInfoExample example);

    int updateByPrimaryKeySelective(RbAutoTranInfo row);

    int updateByPrimaryKey(RbAutoTranInfo row);
}