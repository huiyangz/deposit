package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RcListCheckRange;
import com.dcits.deposit.entity.RcListCheckRangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RcListCheckRangeMapper {
    long countByExample(RcListCheckRangeExample example);

    int deleteByExample(RcListCheckRangeExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo);

    int insert(RcListCheckRange row);

    int insertSelective(RcListCheckRange row);

    List<RcListCheckRange> selectByExample(RcListCheckRangeExample example);

    RcListCheckRange selectByPrimaryKey(@Param("seqNo") String seqNo);

    int updateByExampleSelective(@Param("row") RcListCheckRange row, @Param("example") RcListCheckRangeExample example);

    int updateByExample(@Param("row") RcListCheckRange row, @Param("example") RcListCheckRangeExample example);

    int updateByPrimaryKeySelective(RcListCheckRange row);

    int updateByPrimaryKey(RcListCheckRange row);
}