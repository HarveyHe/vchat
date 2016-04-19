package com.harvey.vchat.rest.impl;    

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.harvey.common.core.service.impl.BaseRestImpl;
import com.harvey.vchat.bas.entity.MessageEntity;
import com.harvey.vchat.bas.model.BasRolesModel;
import com.harvey.vchat.bas.query.BasUsersRolesQueryItem;
import com.harvey.vchat.bas.service.BasRolesService;
import com.harvey.vchat.bas.service.BasUsersRolesService;
import com.harvey.vchat.rest.BasRolesRest;

@Component
public class BasRolesRestImpl extends BaseRestImpl implements BasRolesRest {

	@Resource
    private BasRolesService basRolesService;
	@Resource
	private BasUsersRolesService basUsersRolesService;

	@Override
	public List<BasRolesModel> saveAll(Collection<BasRolesModel> models) {
		return this.basRolesService.saveAll(models);
	}

	@Override
	public List<BasRolesModel> query() {
		return this.basRolesService.query();
	}

	@Override
	public List<BasRolesModel> queryByRoleName(String roleName) {
		return this.basRolesService.queryByRoleName(roleName);
	}

	@Override
	public MessageEntity save(BasRolesModel model) {
		MessageEntity result=new MessageEntity();
		result.setError(false);
		String defRoles[] ={"一般用户","部门联络人","财务主管","出纳员","系统管理员","查询用户"};
		List<BasRolesModel> list;
		String roleName =model.getRoleName();
		
		
		list = this.basRolesService.queryByRoleName(roleName);
		if (StringUtils.isBlank(model.getRoleId())) {
			
			if(list!=null && list.size()>0){
				result.setError(true);
				result.setMessage("角色已存在");
				return result;
			}
		}else{
			BasRolesModel oldModel= this.basRolesService.get(model.getRoleId());
			boolean b = ArrayUtils.contains(defRoles,oldModel.getRoleName());
			if(b){
				result.setError(true);
				result.setMessage("默认角色不能修改！");
				return result;
			}
			if(list!=null && list.size()>0){
				if(!list.get(0).getRoleId().equals(model.getRoleId())){
					result.setError(true);
					result.setMessage("角色已存在");
					return result;
				}
			}
			if("DISABLE".equals(model.getStatus())){
				List<BasUsersRolesQueryItem> itemList=this.basRolesService.queryUsersRolesQueryItemByRoleName(roleName);
				if(itemList!=null && itemList.size()>0){
					result.setError(true);
					result.setMessage("角色有分配用户，禁用不成功");
					return result;
					
				}
			}
		}
		
		this.basRolesService.save(model);
		return result;
	}

	@Override
	public void removeAll(Collection<BasRolesModel> models) {
		this.basRolesService.removeAll(models);
		
	}


	@Override
	public MessageEntity removeAllByPk(String[] ids) {
		MessageEntity entity=this.basRolesService.removeAllByPk(Arrays.asList(ids));
		return entity;
	}

	@Override
	public void saveAllUsersRoles(String usersId, String[] rolesIds) {
		this.basUsersRolesService.saveAllUsersRoles(usersId, rolesIds);
	}
	
}