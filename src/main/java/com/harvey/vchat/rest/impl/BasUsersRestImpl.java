package com.harvey.vchat.rest.impl;    

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.harvey.common.core.context.Context;
import com.harvey.common.core.service.impl.BaseRestImpl;
import com.harvey.vchat.bas.entity.MessageEntity;
import com.harvey.vchat.bas.entity.UserSessionEntity;
import com.harvey.vchat.bas.model.BasRolesModel;
import com.harvey.vchat.bas.model.BasUsersModel;
import com.harvey.vchat.bas.model.BasUsersRolesModel;
import com.harvey.vchat.bas.query.BasUsersListaggQueryItem;
import com.harvey.vchat.bas.service.BasRolesService;
import com.harvey.vchat.bas.service.BasUsersRolesService;
import com.harvey.vchat.bas.service.BasUsersService;
import com.harvey.vchat.bas.utils.ListUtils;
import com.harvey.vchat.common.Constants;
import com.harvey.vchat.rest.BasUsersRest;

@Component
public class BasUsersRestImpl extends BaseRestImpl implements BasUsersRest {

    @Resource(name = "web.userPasswordEncoder")
    private PasswordEncoder passwordEncoder;
	@Resource
    private BasUsersService basUsersService;
	
	@Autowired
	private BasRolesService basRolesService;
	@Autowired
	private BasUsersRolesService basUsersRolesService;
	
	@Override
	public List<BasUsersModel> saveAll(Collection<BasUsersModel> models) {
		return this.basUsersService.saveAll(models);
	}

	@Override
	public List<BasUsersModel> queryEmployeeByDeptNameAndEmployee(
			String departmentName, String employee) {
		return this.basUsersService.queryEmployeeByDeptNameAndEmployee(departmentName, employee);
	}

	@Override
	public List<BasUsersModel> query() {
		
		return this.basUsersService.query();
	}

	@Override
	public MessageEntity save(BasUsersModel model) {
		MessageEntity result=new MessageEntity();
		result.setError(false);
		
        String employeeNo = model.getEmployeeNo();
        BasUsersModel basUsersModel = this.basUsersService.findByEmployeeNo(employeeNo);
        
        if (StringUtils.isBlank(model.getUsersId())) {
            if (basUsersModel!=null) {
            	result.setError(true);
				result.setMessage("系统已存在该用户，请检查！");
				return result;
            }
        } else {
            if (basUsersModel != null && !basUsersModel.getUsersId().equals(model.getUsersId())) {
            	result.setError(true);
            	result.setMessage("系统已存在该用户，请检查！");
            	return result;
            }
            BasUsersModel BasUsersModel =this.basUsersService.findById(model.getUsersId());
            model.setSensitivePassword(BasUsersModel.getSensitivePassword());
        }
        //验证财务主管审批金额不可重叠
        if(model.getFinanceApprovalAmount()!=null && model.getFinanceApprovalAmount()>0){
        	BasUsersModel example = new BasUsersModel();
        	example.setFinanceApprovalAmount(model.getFinanceApprovalAmount());
        	List<BasUsersModel> lists=this.basUsersService.findByExample(example);
        	if(ListUtils.isNotEmpty(lists)){
        		if(StringUtils.isBlank(model.getUsersId())){
        			result.setError(true);
        			result.setMessage("财务主管审批金额不可重叠");
        			return result;
        		}else if(!lists.get(0).getUsersId().equals(model.getUsersId())) {
        			result.setError(true);
        			result.setMessage("财务主管审批金额不可重叠");
        			return result;
					
				}
        		
        	}
        }
		model = this.basUsersService.save(model);
        //给用户赋予一般用户权限
        BasRolesModel commonAuth = basRolesService.getByRoleName("一般用户");
        if (commonAuth != null ) {
			//查找此用户是否已存在一般权限
        	List<BasUsersRolesModel> userRoles = basUsersRolesService.getUserRoles(model.getUsersId(), commonAuth.getRoleId());
        	if (ListUtils.isEmpty(userRoles)) {
        		BasUsersRolesModel newUserRole = new BasUsersRolesModel();
        		newUserRole.setUserId(model.getUsersId());
        		newUserRole.setRoleId(commonAuth.getRoleId());
        		newUserRole.setStatus(Constants.status.ACTIVE);
        		basUsersRolesService.save(newUserRole);
			}
        	
        	
		}
        
        
		return result;
	}

	@Override
	public void removeAll(Collection<BasUsersModel> models) {
		this.basUsersService.removeAll(models);
		
	}

	@Override
	public void clearSensitivePassword(BasUsersModel model) {
		this.basUsersService.clearSensitivePassword(model);
		UserSessionEntity user=Context.getCurrentUser();
		user.setSensitivePassword(null);
	}

	@Override
	public MessageEntity saveSensitivePassword(String password) {
		MessageEntity entity=new MessageEntity();
		entity.setError(false);
		entity.setMessage("修改二次密码成功");
		UserSessionEntity user =Context.getCurrentUser();
		this.basUsersService.saveSensitivePassword(password, user.getEmployeeNo());
		user.setSensitivePassword( passwordEncoder.encode(password));
		user.setIsNeedConfirmPassword("Y");
		log.debug(user.getIsValidatedSensitivePassword());
//		user.setIsValidatedSensitivePassword(Constants.status.Y);
		return entity;
	}

	@Override
	public List<BasUsersListaggQueryItem> queryEmployeeByEmployeeNoAndRoleName(
			String employeeNo, String roleName) {
		return this.basUsersService.queryEmployeeByEmployeeNoAndRoleName(employeeNo, roleName);
	}

	@Override
	public void removeAllByPk(String[] ids) {
		this.basUsersService.removeAllByPk(Arrays.asList(ids));
		
	}

	@Override
	public BasUsersModel findByEmployeeNo(String employeeNo) {
		return basUsersService.findByEmployeeNo(employeeNo);
	}


	@Override
	public String checkHasSensitivePassword() {
		UserSessionEntity user=Context.getCurrentUser();
		if( StringUtils.isNotBlank(user.getSensitivePassword())){
			return user.getSensitivePassword();
		}
		return "";
		
	}

	@Override
	public boolean checkSensitivePassword(String password) {
		UserSessionEntity user=Context.getCurrentUser();
		if(StringUtils.isBlank(user.getSensitivePassword())){
			return false;
		}
		boolean result = passwordEncoder.matches(password, user.getSensitivePassword());
		if(result){
			user.setIsValidatedSensitivePassword(Constants.status.Y);
		}
		return result;
	}

	@Override
	public MessageEntity checkIsValidatedSensitivePassword() {
		MessageEntity entity=new MessageEntity();
		UserSessionEntity user=Context.getCurrentUser();
		//未验证
		if(StringUtils.isBlank(user.getIsValidatedSensitivePassword()) || Constants.status.N.equals(user.getIsValidatedSensitivePassword())){
			String sensitivePassword=user.getSensitivePassword();
			//在没有二次密码的情况下
			if(StringUtils.isBlank(sensitivePassword)){
				entity.setError(true);
				entity.setMessage("未设置敏感二次密码，请在页面右上端设置");
				entity.setResult("N");//未设置
				return entity;
			}else{
				entity.setError(true);
				entity.setResult("Y");//已存在二次敏感密码
				return entity;
			}
		}else if(Constants.status.Y.equals(user.getIsValidatedSensitivePassword())){
			entity.setError(false);
			return entity;
		}
		entity.setError(true);
		entity.setMessage("系统异常");
		return entity;
	}
	@Override
	public MessageEntity checkIsNeedValidatedSensitivePassword() {
		MessageEntity entity=new MessageEntity();
		UserSessionEntity user=Context.getCurrentUser();
		if(StringUtils.isNotBlank(user.getSensitivePassword()) && Constants.status.Y.equals(user.getIsValidatedSensitivePassword())){
			entity.setError(false);
			return entity;
		}
		if(StringUtils.isNotBlank(user.getSensitivePassword())){
			//已设置密码
			entity.setError(true);
			entity.setResult("");
			return entity;
			
		}else if(StringUtils.isBlank(user.getSensitivePassword()) && Constants.status.N.equals(user.getIsNeedConfirmPassword())){
			//在没有二次密码的情况下 ,N 不需要
				entity.setError(false);
				return entity;
		}else if(StringUtils.isBlank(user.getSensitivePassword()) && Constants.status.Y.equals(user.getIsNeedConfirmPassword())) {
			entity.setError(true);
			entity.setMessage("未设置敏感二次密码，请在页面右上端设置");
			entity.setResult("Y");
			return entity;
		}else{
			entity.setError(true);
			entity.setResult("N");//未设置    首次
			return entity;
			
		}
	}

	@Override
	public MessageEntity updateEmployee() {
		MessageEntity messageEntity=new MessageEntity();
		try {
			messageEntity.setError(false);
			messageEntity.setMessage("更新员工信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			messageEntity.setError(true);
			messageEntity.setMessage("更新员工信息失败");
		}
		return messageEntity;
	}

	@Override
	public void setValidatedSensitivePassword(String status) {
		UserSessionEntity user =Context.getCurrentUser();
		user.setIsNeedConfirmPassword("N");
		this.basUsersService.save(user);
		
	}
}