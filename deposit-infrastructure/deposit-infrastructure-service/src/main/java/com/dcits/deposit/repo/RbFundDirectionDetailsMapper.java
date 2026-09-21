package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbFundDirectionDetails;
import com.dcits.deposit.entity.RbFundDirectionDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbFundDirectionDetailsMapper {
    long countByExample(RbFundDirectionDetailsExample example);

    int deleteByExample(RbFundDirectionDetailsExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int insert(RbFundDirectionDetails row);

    int insertSelective(RbFundDirectionDetails row);

    List<RbFundDirectionDetails> selectByExample(RbFundDirectionDetailsExample example);

    RbFundDirectionDetails selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbFundDirectionDetails row, @Param("example") RbFundDirectionDetailsExample example);

    int updateByExample(@Param("row") RbFundDirectionDetails row, @Param("example") RbFundDirectionDetailsExample example);

    int updateByPrimaryKeySelective(RbFundDirectionDetails row);

    int updateByPrimaryKey(RbFundDirectionDetails row);
}