package com.dcits.depsit.repo;

import com.dcits.depsit.entity.RbCorpNatureDef;
import com.dcits.depsit.entity.RbCorpNatureDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbCorpNatureDefMapper {
    long countByExample(RbCorpNatureDefExample example);

    int deleteByExample(RbCorpNatureDefExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo);

    int insert(RbCorpNatureDef row);

    int insertSelective(RbCorpNatureDef row);

    List<RbCorpNatureDef> selectByExample(RbCorpNatureDefExample example);

    RbCorpNatureDef selectByPrimaryKey(@Param("seqNo") String seqNo);

    int updateByExampleSelective(@Param("row") RbCorpNatureDef row, @Param("example") RbCorpNatureDefExample example);

    int updateByExample(@Param("row") RbCorpNatureDef row, @Param("example") RbCorpNatureDefExample example);

    int updateByPrimaryKeySelective(RbCorpNatureDef row);

    int updateByPrimaryKey(RbCorpNatureDef row);
}