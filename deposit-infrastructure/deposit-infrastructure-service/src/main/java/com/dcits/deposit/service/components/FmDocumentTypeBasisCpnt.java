package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AppInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.FmDocumentType;
import com.dcits.deposit.entity.FmDocumentTypeExample;
import com.dcits.deposit.facade.components.IFmDocumentTypeBcc;
import com.dcits.deposit.facade.eo.FmDocumentTypeEO;
import com.dcits.deposit.repo.FmDocumentTypeMapper;
import com.dcits.deposit.service.utils.FmDocumentTypeValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmDocumentTypeBasisCpnt implements IFmDocumentTypeBcc {
    @Autowired
    FmDocumentTypeMapper fmDocumentTypeMapper;

    @Override
    public long countByEo(FmDocumentTypeEO eo) {
        FmDocumentTypeExample example = FmDocumentTypeValueUtil.eoToEntityExample(eo);
        return fmDocumentTypeMapper.countByExample(example);
    }

    @Override
    public int removeByEo(FmDocumentTypeEO eo) {
        FmDocumentTypeExample example = FmDocumentTypeValueUtil.eoToEntityExample(eo);
        return fmDocumentTypeMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String documentType) {
        return fmDocumentTypeMapper.deleteByPrimaryKey(documentType);
    }

    @Override
    public int create(FmDocumentTypeEO eo) {
        FmDocumentType row = FmDocumentTypeValueUtil.eoToEntity(eo);
        return fmDocumentTypeMapper.insert(row);
    }

    @Override
    public int createSelective(FmDocumentTypeEO eo) {
        FmDocumentType row = FmDocumentTypeValueUtil.eoToEntity(eo);
        return fmDocumentTypeMapper.insertSelective(row);
    }

    @Override
    public List<FmDocumentTypeEO> findByEo(FmDocumentTypeEO eo) {
        FmDocumentTypeExample example = FmDocumentTypeValueUtil.eoToEntityExample(eo);
        List<FmDocumentTypeEO> result = new ArrayList<>();
        List<FmDocumentType> dbResult = fmDocumentTypeMapper.selectByExample(example);
        for (FmDocumentType item : dbResult) {
            result.add(FmDocumentTypeValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public FmDocumentTypeEO findByPrimaryKey(String documentType) {
        return FmDocumentTypeValueUtil.entityToEo(fmDocumentTypeMapper.selectByPrimaryKey(documentType));
    }

    @Override
    public int modifyByPrimaryKeySelective(FmDocumentTypeEO eo) {
        FmDocumentType row = FmDocumentTypeValueUtil.eoToEntity(eo);
        return fmDocumentTypeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(FmDocumentTypeEO eo) {
        FmDocumentType row = FmDocumentTypeValueUtil.eoToEntity(eo);
        return fmDocumentTypeMapper.updateByPrimaryKey(row);
    }

    FmDocumentTypeEO byDocumentType(DocumentType documentType) {
        FmDocumentTypeEO eo = new FmDocumentTypeEO();
        eo.setDocumentType(documentType);
        return eo;
    }

    /**根据证件类型查询表《证件类型表(FM_DOCUMENT_TYPE)》**/
    public FmDocumentTypeEO findByDocumentType(DocumentType documentType) {
        List<FmDocumentTypeEO> eos = findByEo(byDocumentType(documentType));
        return eos.isEmpty() ? null : eos.get(0);
    }
}