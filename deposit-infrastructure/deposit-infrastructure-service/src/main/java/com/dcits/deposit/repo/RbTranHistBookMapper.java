package com.dcits.deposit.repo;

import com.dcits.deposit.entity.RbTranHistBook;
import com.dcits.deposit.entity.RbTranHistBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbTranHistBookMapper {
    long countByExample(RbTranHistBookExample example);

    int deleteByExample(RbTranHistBookExample example);

    int deleteByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int insert(RbTranHistBook row);

    int insertSelective(RbTranHistBook row);

    List<RbTranHistBook> selectByExample(RbTranHistBookExample example);

    RbTranHistBook selectByPrimaryKey(@Param("seqNo") String seqNo, @Param("clientNo") String clientNo);

    int updateByExampleSelective(@Param("row") RbTranHistBook row, @Param("example") RbTranHistBookExample example);

    int updateByExample(@Param("row") RbTranHistBook row, @Param("example") RbTranHistBookExample example);

    int updateByPrimaryKeySelective(RbTranHistBook row);

    int updateByPrimaryKey(RbTranHistBook row);
}