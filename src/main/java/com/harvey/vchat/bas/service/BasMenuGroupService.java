package com.harvey.vchat.bas.service;    

import com.harvey.common.core.service.BaseService;
import com.harvey.vchat.bas.model.BasMenuGroupModel;

public interface BasMenuGroupService extends BaseService {

    BasMenuGroupModel get(java.lang.String id);
    
    boolean checkMenuGroupCode(String code);
    
    
    BasMenuGroupModel save(BasMenuGroupModel model);
    
}