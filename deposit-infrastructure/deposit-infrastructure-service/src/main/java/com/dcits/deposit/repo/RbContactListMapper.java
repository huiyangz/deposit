package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbContactList;
import com.dcits.deposit.entity.RbContactListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbContactListMapper {
    long countByExample(RbContactListExample example);

    int deleteByExample(RbContactListExample example);

    int deleteByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("linkmanType") String linkmanType, @Param("phoneNo1") String phoneNo1, @Param("clientNo") String clientNo);

    int insert(RbContactList row);

    int insertSelective(RbContactList row);

    List<RbContactList> selectByExample(RbContactListExample example);

    RbContactList selectByPrimaryKey(@Param("internalKey") Integer internalKey, @Param("linkmanType") String linkmanType, @Param("phoneNo1") String phoneNo1, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbContactList row, @Param("example") RbContactListExample example);

    int updateByExample(@Param("row") RbContactList row, @Param("example") RbContactListExample example);

    int updateByPrimaryKeySelective(RbContactList row);

    int updateByPrimaryKey(RbContactList row);
}