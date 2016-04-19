package com.harvey.vchat.rest.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.harvey.common.core.service.impl.BaseRestImpl;
import com.harvey.vchat.bas.model.BasMenuGroupModel;
import com.harvey.vchat.bas.model.BasMenuItemModel;
import com.harvey.vchat.bas.query.MenuRolesQueryItem;
import com.harvey.vchat.bas.service.BasMenuGroupService;
import com.harvey.vchat.bas.service.BasMenuItemService;
import com.harvey.vchat.bas.service.BasMenuRolesService;
import com.harvey.vchat.rest.BasMenuManagerRest;

@Component
public class BasMenuManagerRestImpl extends BaseRestImpl implements BasMenuManagerRest {

    @Resource
    private BasMenuGroupService basMenuGroupService;
    
    @Resource
    private BasMenuItemService basMenuItemService;
    
    @Resource
    private BasMenuRolesService basMenuRolesService;
    
    @Override
    public BasMenuGroupModel getMenuGroup(String id) {
        return basMenuGroupService.get(id);
    }

    

    @Override
    public boolean checkMenuGroupCode(String code) {
        return this.basMenuGroupService.checkMenuGroupCode(code);
    }


    @Override
    public void saveMenuGroup(@RequestBody BasMenuGroupModel model) {
        basMenuGroupService.save(model);
    }


    @Override
    public boolean removeMenuItem(String id) {
        return basMenuItemService.removeMenuItem(id);
    }


    @Override
    public void saveMenuItem(@RequestBody BasMenuItemModel model) {
        basMenuItemService.saveMenuItem(model);
    }


    @Override
    public void saveMenuRoles(String roleId, @RequestBody Collection<MenuRolesQueryItem> menuRoles) {
        this.basMenuRolesService.saveMenuRoles(roleId, menuRoles);
    }




	@Override
	public BasMenuItemModel getByUrl(BasMenuItemModel model) {
		return basMenuItemService.getByUrl(model);
	}
    
    
}
