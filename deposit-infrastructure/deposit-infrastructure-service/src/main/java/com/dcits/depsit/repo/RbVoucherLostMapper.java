package com.dcits.depsit.repo;

import com.dcits.depsit.entity.RbVoucherLost;
import com.dcits.depsit.entity.RbVoucherLostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbVoucherLostMapper {
    long countByExample(RbVoucherLostExample example);

    int deleteByExample(RbVoucherLostExample example);

    int deleteByPrimaryKey(@Param("lostKey") String lostKey, @Param("lostNo") String lostNo);

    int insert(RbVoucherLost row);

    int insertSelective(RbVoucherLost row);

    List<RbVoucherLost> selectByExample(RbVoucherLostExample example);

    RbVoucherLost selectByPrimaryKey(@Param("lostKey") String lostKey, @Param("lostNo") String lostNo);

    int updateByExampleSelective(@Param("row") RbVoucherLost row, @Param("example") RbVoucherLostExample example);

    int updateByExample(@Param("row") RbVoucherLost row, @Param("example") RbVoucherLostExample example);

    int updateByPrimaryKeySelective(RbVoucherLost row);

    int updateByPrimaryKey(RbVoucherLost row);
}