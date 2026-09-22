package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAcctIntDetail;
import com.dcits.deposit.entity.RbAcctIntDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAcctIntDetailMapper {
    long countByExample(RbAcctIntDetailExample example);

    int deleteByExample(RbAcctIntDetailExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("intClass") String intClass, @Param("clientNo") String clientNo);

    int insert(RbAcctIntDetail row);

    int insertSelective(RbAcctIntDetail row);

    List<RbAcctIntDetail> selectByExample(RbAcctIntDetailExample example);

    RbAcctIntDetail selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("intClass") String intClass, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbAcctIntDetail row, @Param("example") RbAcctIntDetailExample example);

    int updateByExample(@Param("row") RbAcctIntDetail row, @Param("example") RbAcctIntDetailExample example);

    int updateByPrimaryKeySelective(RbAcctIntDetail row);

    int updateByPrimaryKey(RbAcctIntDetail row);
}