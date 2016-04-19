package com.harvey.vchat.bas.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.harvey.common.core.service.BaseService;
import com.harvey.vchat.bas.entity.MessageEntity;
import com.harvey.vchat.bas.model.BasRolesModel;
import com.harvey.vchat.bas.query.BasUsersRolesQueryItem;

public interface BasRolesService extends BaseService {

	List<BasRolesModel> saveAll(Collection<BasRolesModel> models);
	/**
	 * 查询
	 * @return
	 */
	List<BasRolesModel> query();
	
	List<BasRolesModel> queryByRoleName(String roleName);
	
	BasRolesModel save(BasRolesModel model);
	BasRolesModel get(String id);
	
	void removeAll(Collection<BasRolesModel> models);
	
	
	List<BasUsersRolesQueryItem> queryUsersRolesQueryItemByRoleName(String roleName);
	
	MessageEntity removeAllByPk(Collection<? extends Serializable> ids);

	BasRolesModel getByRoleName(String roleName);
	
}
