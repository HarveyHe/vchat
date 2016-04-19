
package com.harvey.vchat.rest;    

import java.util.Collection;
import java.util.List;

import com.harvey.common.core.service.BaseRest;
import com.harvey.vchat.bas.entity.MessageEntity;
import com.harvey.vchat.bas.model.BasUsersModel;
import com.harvey.vchat.bas.query.BasUsersListaggQueryItem;

public interface BasUsersRest extends BaseRest {

	List<BasUsersModel> saveAll(Collection<BasUsersModel> models);
    
    List<BasUsersModel> queryEmployeeByDeptNameAndEmployee(String departmentName,String employee);
    
    /**
     * 查询
     * @return
     */
    List<BasUsersModel> query();
    
    MessageEntity save(BasUsersModel model);
    
    void removeAll(Collection<BasUsersModel> models);
    /**
     * 清除敏感信息二次密码
     * @param model
     */
    void clearSensitivePassword(BasUsersModel model);
    /**
     *保存敏感信息二次密码 
     * @param model
     */
    MessageEntity saveSensitivePassword(String password);
    /**
     * 核对登录人敏感信息二次密码
     */
    MessageEntity checkIsValidatedSensitivePassword();
    
    List<BasUsersListaggQueryItem> queryEmployeeByEmployeeNoAndRoleName(String employeeNo ,String roleName);
    
    public void removeAllByPk(String[] ids);
    
    BasUsersModel findByEmployeeNo(String employeeNo);
    
    
    String checkHasSensitivePassword();
    
    boolean checkSensitivePassword(String password);
    MessageEntity updateEmployee();
    
    void setValidatedSensitivePassword(String status);
    
    MessageEntity checkIsNeedValidatedSensitivePassword();
}
