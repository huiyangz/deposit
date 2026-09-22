package com.dcits.deposit.repo;

import com.dcits.deposit.entity.MbIntBasis;
import com.dcits.deposit.entity.MbIntBasisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbIntBasisMapper {
    long countByExample(MbIntBasisExample example);

    int deleteByExample(MbIntBasisExample example);

    int deleteByPrimaryKey(@Param("intBasis") String intBasis);

    int insert(MbIntBasis row);

    int insertSelective(MbIntBasis row);

    List<MbIntBasis> selectByExample(MbIntBasisExample example);

    MbIntBasis selectByPrimaryKey(@Param("intBasis") String intBasis);

    int updateByExampleSelective(@Param("row") MbIntBasis row, @Param("example") MbIntBasisExample example);

    int updateByExample(@Param("row") MbIntBasis row, @Param("example") MbIntBasisExample example);

    int updateByPrimaryKeySelective(MbIntBasis row);

    int updateByPrimaryKey(MbIntBasis row);
}