package com.dcits.deposit.repo;

import com.dcits.deposit.entity.TbVoucherInfo;
import com.dcits.deposit.entity.TbVoucherInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbVoucherInfoMapper {
    long countByExample(TbVoucherInfoExample example);

    int deleteByExample(TbVoucherInfoExample example);

    int deleteByPrimaryKey(@Param("voucherId") Integer voucherId);

    int insert(TbVoucherInfo row);

    int insertSelective(TbVoucherInfo row);

    List<TbVoucherInfo> selectByExample(TbVoucherInfoExample example);

    TbVoucherInfo selectByPrimaryKey(@Param("voucherId") Integer voucherId);

    int updateByExampleSelective(@Param("row") TbVoucherInfo row, @Param("example") TbVoucherInfoExample example);

    int updateByExample(@Param("row") TbVoucherInfo row, @Param("example") TbVoucherInfoExample example);

    int updateByPrimaryKeySelective(TbVoucherInfo row);

    int updateByPrimaryKey(TbVoucherInfo row);
}