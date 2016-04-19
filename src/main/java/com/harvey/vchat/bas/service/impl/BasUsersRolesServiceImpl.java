package com.harvey.vchat.bas.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harvey.common.core.service.impl.BaseServiceImpl;
import com.harvey.vchat.bas.model.BasRolesModel;
import com.harvey.vchat.bas.model.BasUsersRolesModel;
import com.harvey.vchat.bas.query.BasUsersRolesQueryCondition;
import com.harvey.vchat.bas.query.BasUsersRolesQueryItem;
import com.harvey.vchat.bas.service.BasUsersRolesService;
import com.harvey.vchat.bas.utils.ListUtils;
import com.harvey.vchat.bas.utils.StringUtils;
import com.harvey.vchat.common.Constants;

@Service
public class BasUsersRolesServiceImpl extends BaseServiceImpl implements BasUsersRolesService {

    public List<BasUsersRolesModel> saveAll(Collection<BasUsersRolesModel> models) {
        return (List<BasUsersRolesModel>) this.dao.saveAll(models);
    }

    @Override
    public void saveAllUsersRoles(String usersId, String[] rolesIds) {
    	if(StringUtils.isBlank(usersId)){
    		throw new RuntimeException("请选择一位用户,为该用户分配角色");
    	}
        BasUsersRolesQueryCondition condition = new BasUsersRolesQueryCondition();
        condition.setUsersId(usersId);
        List<BasUsersRolesQueryItem> oldItemList = this.dao.query(condition, BasUsersRolesQueryItem.class);

        List<BasUsersRolesModel> models = new ArrayList<BasUsersRolesModel>();
        List<BasRolesModel> list = this.dao.getAll(BasRolesModel.class);
        for (BasRolesModel basRolesModel : list) {
            BasUsersRolesModel model = new BasUsersRolesModel();
            model.setRoleId(basRolesModel.getRoleId());
            model.setStatus(Constants.status.DISABLED);
            model.setUserId(usersId);
            if(rolesIds!=null){
            	for (String id : rolesIds) {
            		if (id.equals(basRolesModel.getRoleId())) {
            			model.setStatus(Constants.status.ACTIVE);
            			
            		}
            	}
            }
            if (ListUtils.isNotEmpty(oldItemList)) {
                for (BasUsersRolesQueryItem basUsersRolesQueryItem : oldItemList) {
                    if (basUsersRolesQueryItem.getRoleId().equals(basRolesModel.getRoleId())) {
                        model.setBasUsersRolesId(basUsersRolesQueryItem.getBasUsersRolesId());
                    }
                }
            }
            models.add(model);
        }

        this.saveAll(models);
    }

    @Override
    public List<BasUsersRolesModel> getUserRoles(String usersId) {
        BasUsersRolesModel example = new BasUsersRolesModel();
        example.setStatus(Constants.status.ACTIVE);
        example.setUserId(usersId);
        return this.dao.findByExample(example);
    }
    @Override
    public List<BasUsersRolesModel> getUserRoles(String usersId,String rolesId) {
    	BasUsersRolesModel example = new BasUsersRolesModel();
//    	example.setStatus(Constants.status.ACTIVE);
    	example.setUserId(usersId);
    	example.setRoleId(rolesId);
    	return this.dao.findByExample(example);
    }

	@Override
	public void save(BasUsersRolesModel model) {
		this.dao.save(model);
		
	}

}
