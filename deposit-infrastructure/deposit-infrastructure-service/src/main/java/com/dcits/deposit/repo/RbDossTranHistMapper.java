package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbDossTranHist;
import com.dcits.deposit.entity.RbDossTranHistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbDossTranHistMapper {
    long countByExample(RbDossTranHistExample example);

    int deleteByExample(RbDossTranHistExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo, @Param("internalKey") Integer internalKey);

    int insert(RbDossTranHist row);

    int insertSelective(RbDossTranHist row);

    List<RbDossTranHist> selectByExample(RbDossTranHistExample example);

    RbDossTranHist selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo, @Param("internalKey") Integer internalKey);

    int updateByExampleSelective(@Param("row") RbDossTranHist row, @Param("example") RbDossTranHistExample example);

    int updateByExample(@Param("row") RbDossTranHist row, @Param("example") RbDossTranHistExample example);

    int updateByPrimaryKeySelective(RbDossTranHist row);

    int updateByPrimaryKey(RbDossTranHist row);
}