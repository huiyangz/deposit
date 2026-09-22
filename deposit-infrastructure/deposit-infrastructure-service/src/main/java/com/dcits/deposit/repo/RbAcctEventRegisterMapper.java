package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbAcctEventRegister;
import com.dcits.deposit.entity.RbAcctEventRegisterExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbAcctEventRegisterMapper {
    long countByExample(RbAcctEventRegisterExample example);

    int deleteByExample(RbAcctEventRegisterExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("tranDate") Date tranDate, @Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo, @Param("intClass") String intClass);

    int insert(RbAcctEventRegister row);

    int insertSelective(RbAcctEventRegister row);

    List<RbAcctEventRegister> selectByExample(RbAcctEventRegisterExample example);

    RbAcctEventRegister selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("tranDate") Date tranDate, @Param("internalKey") Integer internalKey, @Param("clientNo") String clientNo, @Param("intClass") String intClass);

    int updateByExampleSelective(@Param("row") RbAcctEventRegister row, @Param("example") RbAcctEventRegisterExample example);

    int updateByExample(@Param("row") RbAcctEventRegister row, @Param("example") RbAcctEventRegisterExample example);

    int updateByPrimaryKeySelective(RbAcctEventRegister row);

    int updateByPrimaryKey(RbAcctEventRegister row);
}