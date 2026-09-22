package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbVoucherAcctRelation;
import com.dcits.deposit.entity.RbVoucherAcctRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbVoucherAcctRelationMapper {
    long countByExample(RbVoucherAcctRelationExample example);

    int deleteByExample(RbVoucherAcctRelationExample example);

    int deleteByPrimaryKey(@Param("baseAcctNo") String baseAcctNo, @Param("docType") String docType, @Param("voucherNo") String voucherNo, @Param("clientNo") String clientNo);

    int insert(RbVoucherAcctRelation row);

    int insertSelective(RbVoucherAcctRelation row);

    List<RbVoucherAcctRelation> selectByExample(RbVoucherAcctRelationExample example);

    RbVoucherAcctRelation selectByPrimaryKey(@Param("baseAcctNo") String baseAcctNo, @Param("docType") String docType, @Param("voucherNo") String voucherNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbVoucherAcctRelation row, @Param("example") RbVoucherAcctRelationExample example);

    int updateByExample(@Param("row") RbVoucherAcctRelation row, @Param("example") RbVoucherAcctRelationExample example);

    int updateByPrimaryKeySelective(RbVoucherAcctRelation row);

    int updateByPrimaryKey(RbVoucherAcctRelation row);
}