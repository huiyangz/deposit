package com.dcits.depsit.repo;

import com.dcits.depsit.entity.RbBusApprLetter;
import com.dcits.depsit.entity.RbBusApprLetterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBusApprLetterMapper {
    long countByExample(RbBusApprLetterExample example);

    int deleteByExample(RbBusApprLetterExample example);

    int deleteByPrimaryKey(@Param("apprLetterNo") String apprLetterNo, @Param("clientNo") String clientNo);

    int insert(RbBusApprLetter row);

    int insertSelective(RbBusApprLetter row);

    List<RbBusApprLetter> selectByExample(RbBusApprLetterExample example);

    RbBusApprLetter selectByPrimaryKey(@Param("apprLetterNo") String apprLetterNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbBusApprLetter row, @Param("example") RbBusApprLetterExample example);

    int updateByExample(@Param("row") RbBusApprLetter row, @Param("example") RbBusApprLetterExample example);

    int updateByPrimaryKeySelective(RbBusApprLetter row);

    int updateByPrimaryKey(RbBusApprLetter row);
}