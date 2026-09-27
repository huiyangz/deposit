package com.dcits.deposit.repo;

import com.dcits.deposit.entity.FmDocumentType;
import com.dcits.deposit.entity.FmDocumentTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmDocumentTypeMapper {
    long countByExample(FmDocumentTypeExample example);

    int deleteByExample(FmDocumentTypeExample example);

    int deleteByPrimaryKey(@Param("documentType") String documentType);

    int insert(FmDocumentType row);

    int insertSelective(FmDocumentType row);

    List<FmDocumentType> selectByExample(FmDocumentTypeExample example);

    FmDocumentType selectByPrimaryKey(@Param("documentType") String documentType);

    int updateByExampleSelective(@Param("row") FmDocumentType row, @Param("example") FmDocumentTypeExample example);

    int updateByExample(@Param("row") FmDocumentType row, @Param("example") FmDocumentTypeExample example);

    int updateByPrimaryKeySelective(FmDocumentType row);

    int updateByPrimaryKey(FmDocumentType row);
}