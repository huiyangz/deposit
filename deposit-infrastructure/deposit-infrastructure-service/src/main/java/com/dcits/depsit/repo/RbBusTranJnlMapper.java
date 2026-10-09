package com.dcits.depsit.repo;

import com.dcits.depsit.entity.RbBusTranJnl;
import com.dcits.depsit.entity.RbBusTranJnlExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusTranJnlMapper {
    long countByExample(RbBusTranJnlExample example);

    int deleteByExample(RbBusTranJnlExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("tranDate") Date tranDate);

    int insert(RbBusTranJnl row);

    int insertSelective(RbBusTranJnl row);

    List<RbBusTranJnl> selectByExample(RbBusTranJnlExample example);

    RbBusTranJnl selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("tranDate") Date tranDate);

    int updateByExampleSelective(@Param("row") RbBusTranJnl row, @Param("example") RbBusTranJnlExample example);

    int updateByExample(@Param("row") RbBusTranJnl row, @Param("example") RbBusTranJnlExample example);

    int updateByPrimaryKeySelective(RbBusTranJnl row);

    int updateByPrimaryKey(RbBusTranJnl row);
}