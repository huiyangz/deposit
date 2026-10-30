package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbFeeAmortize;
import com.dcits.deposit.entity.RbFeeAmortizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbFeeAmortizeMapper {
    long countByExample(RbFeeAmortizeExample example);

    int deleteByExample(RbFeeAmortizeExample example);

    int deleteByPrimaryKey(@Param("amortizeId") String amortizeId);

    int insert(RbFeeAmortize row);

    int insertSelective(RbFeeAmortize row);

    List<RbFeeAmortize> selectByExample(RbFeeAmortizeExample example);

    RbFeeAmortize selectByPrimaryKey(@Param("amortizeId") String amortizeId);

    int updateByExampleSelective(@Param("row") RbFeeAmortize row, @Param("example") RbFeeAmortizeExample example);

    int updateByExample(@Param("row") RbFeeAmortize row, @Param("example") RbFeeAmortizeExample example);

    int updateByPrimaryKeySelective(RbFeeAmortize row);

    int updateByPrimaryKey(RbFeeAmortize row);
}