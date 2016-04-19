package com.harvey.vchat.bas.service;

import com.harvey.common.core.service.BaseService;
import com.harvey.vchat.bas.model.BasMenuItemModel;

public interface BasMenuItemService extends BaseService {

    BasMenuItemModel saveMenuItem(BasMenuItemModel model);
    
    boolean removeMenuItem(String itemId);
    
    
    
    /**
     * 根据url寻找标题，有可能返回的不是数据库中的数据而是自己新建的model
     * @param model
     * @return
     */
    BasMenuItemModel getByUrl(BasMenuItemModel model);
}
