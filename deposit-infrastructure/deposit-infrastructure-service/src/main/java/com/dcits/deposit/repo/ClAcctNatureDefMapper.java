package com.dcits.deposit.repo;

import com.dcits.deposit.entity.ClAcctNatureDef;
import com.dcits.deposit.entity.ClAcctNatureDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClAcctNatureDefMapper {
    long countByExample(ClAcctNatureDefExample example);

    int deleteByExample(ClAcctNatureDefExample example);

    int deleteByPrimaryKey(@Param("acctNature") String acctNature);

    int insert(ClAcctNatureDef row);

    int insertSelective(ClAcctNatureDef row);

    List<ClAcctNatureDef> selectByExample(ClAcctNatureDefExample example);

    ClAcctNatureDef selectByPrimaryKey(@Param("acctNature") String acctNature);

    int updateByExampleSelective(@Param("row") ClAcctNatureDef row, @Param("example") ClAcctNatureDefExample example);

    int updateByExample(@Param("row") ClAcctNatureDef row, @Param("example") ClAcctNatureDefExample example);

    int updateByPrimaryKeySelective(ClAcctNatureDef row);

    int updateByPrimaryKey(ClAcctNatureDef row);
}