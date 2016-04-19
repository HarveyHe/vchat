package com.harvey.vchat.bas.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.harvey.common.core.service.impl.BaseServiceImpl;
import com.harvey.vchat.bas.entity.MessageEntity;
import com.harvey.vchat.bas.model.BasRolesModel;
import com.harvey.vchat.bas.model.BasUsersRolesModel;
import com.harvey.vchat.bas.query.BasUsersRolesQueryCondition;
import com.harvey.vchat.bas.query.BasUsersRolesQueryItem;
import com.harvey.vchat.bas.service.BasRolesService;
import com.harvey.vchat.bas.utils.ListUtils;
import com.harvey.vchat.common.Constants;

@Service
public class BasRolesServiceImpl extends BaseServiceImpl implements BasRolesService {

	public List<BasRolesModel> saveAll(Collection<BasRolesModel> models) {
		return (List<BasRolesModel>) this.dao.saveAll(models);
	}

	@Override
	public List<BasRolesModel> query() {
		return this.dao.getAll(BasRolesModel.class,"roleName desc");
	}

	@Override
	public BasRolesModel save(BasRolesModel model) {
		
		return this.dao.save(model);
	}

	@Override
	public void removeAll(Collection<BasRolesModel> models) {
		for (BasRolesModel basRolesModel : models) {
		    BasUsersRolesQueryCondition condition = new BasUsersRolesQueryCondition();
            condition.setRoleName(basRolesModel.getRoleName());
            List<BasUsersRolesQueryItem> itemList=this.dao.query(condition, BasUsersRolesQueryItem.class);
			if(itemList!=null && itemList.size()>0){
				throw new RuntimeException(basRolesModel.getRoleName()+":此角色有用户记录关联，不可删除！");
			}
		}
		this.dao.removeAll(models);
	}

	@Override
	public List<BasRolesModel> queryByRoleName(String roleName) {
		if(StringUtils.isBlank(roleName)){
			return query();
		}
		BasRolesModel example = new BasRolesModel();
		example.setRoleName(roleName);
		return this.dao.findByExample(example,"roleName desc");
	}

	@Override
	public List<BasUsersRolesQueryItem> queryUsersRolesQueryItemByRoleName(
			String roleName) {

	    BasUsersRolesQueryCondition condition = new BasUsersRolesQueryCondition();
	    condition.setRoleName(roleName);
		return this.dao.query(condition, BasUsersRolesQueryItem.class);
	}

	@Override
	public MessageEntity removeAllByPk(Collection<? extends Serializable> ids) {
		String defRoles[] ={"一般用户","部门联络人","财务主管","出纳员","系统管理员","查询用户"};
		MessageEntity entity=new MessageEntity();
		entity.setError(false);
		//1判断该角色   是否存着用户是该角色的
		String message="";
		for (Serializable id : ids) {
			BasRolesModel roleModel=this.dao.get(BasRolesModel.class, id);
			
			boolean b = ArrayUtils.contains(defRoles,roleModel.getRoleName());
			if(b){
				entity.setError(true);
				entity.setMessage(roleModel.getRoleName() +"：默认角色不能删除！");
				return entity;
			}
			
			
			List<BasUsersRolesModel> basUsersRolesModels=null;
			BasUsersRolesModel usersRolesExample=new BasUsersRolesModel();
			usersRolesExample.setRoleId(roleModel.getRoleId());
			usersRolesExample.setStatus(Constants.status.ACTIVE);
			basUsersRolesModels=this.dao.findByExample(usersRolesExample);
			if(ListUtils.isEmpty(basUsersRolesModels)){//不含用户
				usersRolesExample=new BasUsersRolesModel();
				usersRolesExample.setRoleId(roleModel.getRoleId());
				basUsersRolesModels=this.dao.findByExample(usersRolesExample);
				//删除无效的用户角色关联
				this.dao.removeAll(basUsersRolesModels);
				
				//删除菜单权限
				this.sqlDao.bulkUpdate("delete bas_menu_roles where role_id = ?", roleModel.getRoleId());
				this.dao.remove(roleModel);
			}else{
				entity.setError(true);
				message+=roleModel.getRoleName()+",此角色有用户记录关联，不可删除！";
				entity.setMessage(message);
			}
			
		}
		return entity;
	}

	@Override
	public BasRolesModel get(String id) {
		return this.dao.get(BasRolesModel.class, id);
	}

	@Override
	public BasRolesModel getByRoleName(String roleName) {
		if (StringUtils.isNoneBlank(roleName)) {
			BasRolesModel model = new BasRolesModel();
			model.setRoleName(roleName);
			List<BasRolesModel> models = this.dao.findByExample(model);
			if (ListUtils.isNotEmpty(models) && models.size() == 1) {
				return models.get(0);
			}
		}
		
		return null;
	}
	
}
