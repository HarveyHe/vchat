package com.harvey.vchat.bas.service;    

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.harvey.common.core.service.BaseService;
import com.harvey.vchat.bas.model.BasUsersModel;
import com.harvey.vchat.bas.query.BasUsersListaggQueryItem;

public interface BasUsersService extends BaseService {

List<BasUsersModel> saveAll(Collection<BasUsersModel> models);
    
    List<BasUsersModel> queryEmployeeByDeptNameAndEmployee(String departmentName,String employee);
    
    /**
     * 查询
     * @return
     */
    List<BasUsersModel> query();
    
    BasUsersModel save(BasUsersModel model);
    
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
    void saveSensitivePassword(String password,String employeeNO);
    
    
    List<BasUsersListaggQueryItem> queryEmployeeByEmployeeNoAndRoleName(String employeeNo ,String roleName);
    
    BasUsersModel findByEmployeeNo(String employeeNo );
    
    BasUsersModel findById(String userId );
    
    List<BasUsersListaggQueryItem> queryEmployeeByRoleName(String roleName);
    
    void removeAllByPk(Collection<? extends Serializable> ids);
    
    
    List<BasUsersModel> findByExample(BasUsersModel example);
    
}