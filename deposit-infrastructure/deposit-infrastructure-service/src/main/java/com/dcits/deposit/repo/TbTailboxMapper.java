package com.dcits.deposit.repo;

import com.dcits.deposit.entity.TbTailbox;
import com.dcits.deposit.entity.TbTailboxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTailboxMapper {
    long countByExample(TbTailboxExample example);

    int deleteByExample(TbTailboxExample example);

    int deleteByPrimaryKey(@Param("tailboxId") String tailboxId);

    int insert(TbTailbox row);

    int insertSelective(TbTailbox row);

    List<TbTailbox> selectByExample(TbTailboxExample example);

    TbTailbox selectByPrimaryKey(@Param("tailboxId") String tailboxId);

    int updateByExampleSelective(@Param("row") TbTailbox row, @Param("example") TbTailboxExample example);

    int updateByExample(@Param("row") TbTailbox row, @Param("example") TbTailboxExample example);

    int updateByPrimaryKeySelective(TbTailbox row);

    int updateByPrimaryKey(TbTailbox row);
}