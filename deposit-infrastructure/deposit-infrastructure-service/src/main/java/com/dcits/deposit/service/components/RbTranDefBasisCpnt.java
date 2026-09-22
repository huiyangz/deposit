package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AvailbalCalcType;
import com.dcits.deposit.enums.BalanceFlag;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranClass;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.UpdTailboxFlag;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbTranDef;
import com.dcits.deposit.entity.RbTranDefExample;
import com.dcits.deposit.facade.components.IRbTranDefBcc;
import com.dcits.deposit.facade.eo.RbTranDefEO;
import com.dcits.deposit.repo.RbTranDefMapper;
import com.dcits.deposit.service.utils.RbTranDefValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbTranDefBasisCpnt implements IRbTranDefBcc {
    @Autowired
    RbTranDefMapper rbTranDefMapper;

    @Override
    public long countByEo(RbTranDefEO eo) {
        RbTranDefExample example = RbTranDefValueUtil.eoToEntityExample(eo);
        return rbTranDefMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbTranDefEO eo) {
        RbTranDefExample example = RbTranDefValueUtil.eoToEntityExample(eo);
        return rbTranDefMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String tranType) {
        return rbTranDefMapper.deleteByPrimaryKey(tranType);
    }

    @Override
    public int create(RbTranDefEO eo) {
        RbTranDef row = RbTranDefValueUtil.eoToEntity(eo);
        return rbTranDefMapper.insert(row);
    }

    @Override
    public int createSelective(RbTranDefEO eo) {
        RbTranDef row = RbTranDefValueUtil.eoToEntity(eo);
        return rbTranDefMapper.insertSelective(row);
    }

    @Override
    public List<RbTranDefEO> findByEo(RbTranDefEO eo) {
        RbTranDefExample example = RbTranDefValueUtil.eoToEntityExample(eo);
        List<RbTranDefEO> result = new ArrayList<>();
        List<RbTranDef> dbResult = rbTranDefMapper.selectByExample(example);
        for (RbTranDef item : dbResult) {
            result.add(RbTranDefValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbTranDefEO findByPrimaryKey(String tranType) {
        return RbTranDefValueUtil.entityToEo(rbTranDefMapper.selectByPrimaryKey(tranType));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbTranDefEO eo) {
        RbTranDef row = RbTranDefValueUtil.eoToEntity(eo);
        return rbTranDefMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbTranDefEO eo) {
        RbTranDef row = RbTranDefValueUtil.eoToEntity(eo);
        return rbTranDefMapper.updateByPrimaryKey(row);
    }

    RbTranDefEO byTranType(TranType tranType) {
        RbTranDefEO eo = new RbTranDefEO();
        eo.setTranType(tranType);
        return eo;
    }

    /**根据交易类型查询表《交易类型定义表(RB_TRAN_DEF)》**/
    public RbTranDefEO findByTranType(TranType tranType) {
        List<RbTranDefEO> eos = findByEo(byTranType(tranType));
        return eos.isEmpty() ? null : eos.get(0);
    }
}