package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbBusVoucherAcctRelation;
import com.dcits.deposit.entity.RbBusVoucherAcctRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusVoucherAcctRelationMapper {
    long countByExample(RbBusVoucherAcctRelationExample example);

    int deleteByExample(RbBusVoucherAcctRelationExample example);

    int deleteByPrimaryKey(@Param("docType") String docType, @Param("baseAcctNo") String baseAcctNo, @Param("voucherNo") String voucherNo);

    int insert(RbBusVoucherAcctRelation row);

    int insertSelective(RbBusVoucherAcctRelation row);

    List<RbBusVoucherAcctRelation> selectByExample(RbBusVoucherAcctRelationExample example);

    RbBusVoucherAcctRelation selectByPrimaryKey(@Param("docType") String docType, @Param("baseAcctNo") String baseAcctNo, @Param("voucherNo") String voucherNo);

    int updateByExampleSelective(@Param("row") RbBusVoucherAcctRelation row, @Param("example") RbBusVoucherAcctRelationExample example);

    int updateByExample(@Param("row") RbBusVoucherAcctRelation row, @Param("example") RbBusVoucherAcctRelationExample example);

    int updateByPrimaryKeySelective(RbBusVoucherAcctRelation row);

    int updateByPrimaryKey(RbBusVoucherAcctRelation row);
}