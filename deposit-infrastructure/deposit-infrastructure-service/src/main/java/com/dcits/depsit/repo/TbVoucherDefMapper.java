package com.dcits.depsit.repo;

import com.dcits.depsit.entity.TbVoucherDef;
import com.dcits.depsit.entity.TbVoucherDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbVoucherDefMapper {
    long countByExample(TbVoucherDefExample example);

    int deleteByExample(TbVoucherDefExample example);

    int deleteByPrimaryKey(@Param("docType") String docType);

    int insert(TbVoucherDef row);

    int insertSelective(TbVoucherDef row);

    List<TbVoucherDef> selectByExample(TbVoucherDefExample example);

    TbVoucherDef selectByPrimaryKey(@Param("docType") String docType);

    int updateByExampleSelective(@Param("row") TbVoucherDef row, @Param("example") TbVoucherDefExample example);

    int updateByExample(@Param("row") TbVoucherDef row, @Param("example") TbVoucherDefExample example);

    int updateByPrimaryKeySelective(TbVoucherDef row);

    int updateByPrimaryKey(TbVoucherDef row);
}