package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbClientAcctRelation;
import com.dcits.deposit.entity.RbClientAcctRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbClientAcctRelationMapper {
    long countByExample(RbClientAcctRelationExample example);

    int deleteByExample(RbClientAcctRelationExample example);

    int deleteByPrimaryKey(@Param("baseAcctNo") String baseAcctNo, @Param("clientNo") String clientNo, @Param("acctSeqNo") String acctSeqNo);

    int insert(RbClientAcctRelation row);

    int insertSelective(RbClientAcctRelation row);

    List<RbClientAcctRelation> selectByExample(RbClientAcctRelationExample example);

    RbClientAcctRelation selectByPrimaryKey(@Param("baseAcctNo") String baseAcctNo, @Param("clientNo") String clientNo, @Param("acctSeqNo") String acctSeqNo);

    int updateByExampleSelective(@Param("row") RbClientAcctRelation row, @Param("example") RbClientAcctRelationExample example);

    int updateByExample(@Param("row") RbClientAcctRelation row, @Param("example") RbClientAcctRelationExample example);

    int updateByPrimaryKeySelective(RbClientAcctRelation row);

    int updateByPrimaryKey(RbClientAcctRelation row);
}