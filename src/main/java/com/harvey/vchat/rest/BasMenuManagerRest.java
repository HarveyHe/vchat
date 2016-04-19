package com.harvey.vchat.rest;

import java.util.Collection;

import com.harvey.common.core.service.BaseRest;
import com.harvey.vchat.bas.model.BasMenuGroupModel;
import com.harvey.vchat.bas.model.BasMenuItemModel;
import com.harvey.vchat.bas.query.MenuRolesQueryItem;

/**
 * 菜单分组http rest api
 * rest url映射规则为：
   /rest/接口名小写开头/方法名.json
   如：保存菜单分组 rest url为: /rest/basMenuManagerRest/save.json
 */
public interface BasMenuManagerRest extends BaseRest {
    
    /**
     * 保存菜单分组
     * @param model 菜单分组信息
     */
    void saveMenuGroup(BasMenuGroupModel model);
    
    /**
     * 获取菜单分组信息
     * @param id
     * @return 菜单分组信息
     */
    BasMenuGroupModel getMenuGroup(String id);
    
    
    boolean checkMenuGroupCode(String code);
    
    boolean removeMenuItem(String id);
    
    void saveMenuItem(BasMenuItemModel model);
    
    void saveMenuRoles(String roleId,Collection<MenuRolesQueryItem> menuRoles);
    
    
    BasMenuItemModel getByUrl(BasMenuItemModel model);
}
