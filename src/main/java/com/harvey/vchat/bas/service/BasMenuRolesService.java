package com.harvey.vchat.bas.service;

import java.util.Collection;

import org.springframework.beans.factory.InitializingBean;

import com.harvey.common.core.service.BaseService;
import com.harvey.vchat.bas.query.MenuRolesQueryItem;

public interface BasMenuRolesService extends BaseService,InitializingBean {
    
    void saveMenuRoles(String roleId,Collection<MenuRolesQueryItem> menuRoles);
    
}
