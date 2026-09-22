package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAcctIntDetailPre;
import com.dcits.deposit.entity.RbAcctIntDetailPreExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAcctIntDetailPreMapper {
    long countByExample(RbAcctIntDetailPreExample example);

    int deleteByExample(RbAcctIntDetailPreExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("intClass") String intClass, @Param("agg") BigDecimal agg, @Param("clientNo") String clientNo, @Param("tranTimestamp") String tranTimestamp);

    int insert(RbAcctIntDetailPre row);

    int insertSelective(RbAcctIntDetailPre row);

    List<RbAcctIntDetailPre> selectByExample(RbAcctIntDetailPreExample example);

    RbAcctIntDetailPre selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("intClass") String intClass, @Param("agg") BigDecimal agg, @Param("clientNo") String clientNo, @Param("tranTimestamp") String tranTimestamp);

    int updateByExampleSelective(@Param("row") RbAcctIntDetailPre row, @Param("example") RbAcctIntDetailPreExample example);

    int updateByExample(@Param("row") RbAcctIntDetailPre row, @Param("example") RbAcctIntDetailPreExample example);

    int updateByPrimaryKeySelective(RbAcctIntDetailPre row);

    int updateByPrimaryKey(RbAcctIntDetailPre row);
}