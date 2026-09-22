package com.dcits.deposit.repo;

import com.dcits.deposit.entity.FmState;
import com.dcits.deposit.entity.FmStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmStateMapper {
    long countByExample(FmStateExample example);

    int deleteByExample(FmStateExample example);

    int deleteByPrimaryKey(@Param("country") String country, @Param("state") String state);

    int insert(FmState row);

    int insertSelective(FmState row);

    List<FmState> selectByExample(FmStateExample example);

    FmState selectByPrimaryKey(@Param("country") String country, @Param("state") String state);

    int updateByExampleSelective(@Param("row") FmState row, @Param("example") FmStateExample example);

    int updateByExample(@Param("row") FmState row, @Param("example") FmStateExample example);

    int updateByPrimaryKeySelective(FmState row);

    int updateByPrimaryKey(FmState row);
}