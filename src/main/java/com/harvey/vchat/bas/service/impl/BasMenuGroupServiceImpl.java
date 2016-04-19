package com.harvey.vchat.bas.service.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.harvey.common.core.service.impl.BaseServiceImpl;
import com.harvey.vchat.bas.model.BasMenuGroupModel;
import com.harvey.vchat.bas.service.BasMenuGroupService;

@Service
public class BasMenuGroupServiceImpl extends BaseServiceImpl implements BasMenuGroupService {

    public BasMenuGroupModel get(java.lang.String id) {
        return this.dao.get(BasMenuGroupModel.class, id);
    }

    public BasMenuGroupModel save(BasMenuGroupModel model) {
        return this.dao.save(model);
    }

    public BasMenuGroupModel saveAll(BasMenuGroupModel model) {
        return this.dao.save(model);
    }



    @Override
    public boolean checkMenuGroupCode(String code) {
        Criteria criteria = this.dao.createCriteria(BasMenuGroupModel.class);
        criteria.setProjection(Projections.rowCount()).add(Restrictions.eq("menuGrpCode", code));
        Number num = (Number) criteria.uniqueResult();
        return num != null && num.intValue() > 0;
    }
}