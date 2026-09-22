package com.dcits.deposit.repo;

import com.dcits.deposit.entity.MbEventAttr;
import com.dcits.deposit.entity.MbEventAttrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbEventAttrMapper {
    long countByExample(MbEventAttrExample example);

    int deleteByExample(MbEventAttrExample example);

    int deleteByPrimaryKey(@Param("eventType") String eventType, @Param("seqNo") String seqNo, @Param("company") String company);

    int insert(MbEventAttr row);

    int insertSelective(MbEventAttr row);

    List<MbEventAttr> selectByExample(MbEventAttrExample example);

    MbEventAttr selectByPrimaryKey(@Param("eventType") String eventType, @Param("seqNo") String seqNo, @Param("company") String company);

    int updateByExampleSelective(@Param("row") MbEventAttr row, @Param("example") MbEventAttrExample example);

    int updateByExample(@Param("row") MbEventAttr row, @Param("example") MbEventAttrExample example);

    int updateByPrimaryKeySelective(MbEventAttr row);

    int updateByPrimaryKey(MbEventAttr row);
}