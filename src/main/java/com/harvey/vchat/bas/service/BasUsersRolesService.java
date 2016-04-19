package com.harvey.vchat.bas.service;

import java.util.Collection;
import java.util.List;

import com.harvey.common.core.service.BaseService;
import com.harvey.vchat.bas.model.BasUsersRolesModel;

public interface BasUsersRolesService extends BaseService {

	List<BasUsersRolesModel> saveAll(Collection<BasUsersRolesModel> models);
	
	void saveAllUsersRoles(String usersId,String[] rolesIds);
	void save(BasUsersRolesModel model);
	
	List<BasUsersRolesModel> getUserRoles(String usersId);
	List<BasUsersRolesModel> getUserRoles(String usersId,String rolesId);

}
