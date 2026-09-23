package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusFundDirectionDetails;
import com.dcits.deposit.entity.RbBusFundDirectionDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusFundDirectionDetailsMapper {
    long countByExample(RbBusFundDirectionDetailsExample example);

    int deleteByExample(RbBusFundDirectionDetailsExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo);

    int insert(RbBusFundDirectionDetails row);

    int insertSelective(RbBusFundDirectionDetails row);

    List<RbBusFundDirectionDetails> selectByExample(RbBusFundDirectionDetailsExample example);

    RbBusFundDirectionDetails selectByPrimaryKey(@Param("seqNo") String seqNo);

    int updateByExampleSelective(@Param("row") RbBusFundDirectionDetails row, @Param("example") RbBusFundDirectionDetailsExample example);

    int updateByExample(@Param("row") RbBusFundDirectionDetails row, @Param("example") RbBusFundDirectionDetailsExample example);

    int updateByPrimaryKeySelective(RbBusFundDirectionDetails row);

    int updateByPrimaryKey(RbBusFundDirectionDetails row);
}