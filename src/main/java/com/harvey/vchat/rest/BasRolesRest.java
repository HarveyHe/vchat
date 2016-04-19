package com.harvey.vchat.rest;    

import java.util.Collection;
import java.util.List;

import com.harvey.common.core.service.BaseRest;
import com.harvey.vchat.bas.entity.MessageEntity;
import com.harvey.vchat.bas.model.BasRolesModel;

public interface BasRolesRest extends BaseRest {
	List<BasRolesModel> saveAll(Collection<BasRolesModel> models);
	/**
	 * 查询
	 * @return
	 */
	List<BasRolesModel> query();
	
	List<BasRolesModel> queryByRoleName(String roleName);
	
	MessageEntity save(BasRolesModel model);
	
	void removeAll(Collection<BasRolesModel> models);
	
	
	public MessageEntity removeAllByPk(String[] ids);
	
	public void saveAllUsersRoles(String usersId, String[] rolesIds);
}