package com.harvey.vchat.bas.query;   

import java.io.Serializable;

/**
 * Query Condition class for BasUsersRolesQuery
 */
public class BasUsersRolesQueryCondition implements Serializable{
    
    private static final long serialVersionUID = 1L;
    

    private java.lang.String roleName;
    
    public java.lang.String getRoleName(){
        return this.roleName;
    }
    
    public void setRoleName(java.lang.String roleName){
        this.roleName = roleName;
    }
        

    private java.lang.String employeeNo;
    
    public java.lang.String getEmployeeNo(){
        return this.employeeNo;
    }
    
    public void setEmployeeNo(java.lang.String employeeNo){
        this.employeeNo = employeeNo;
    }
        

    private java.lang.String usersId;
    
    public java.lang.String getUsersId(){
        return this.usersId;
    }
    
    public void setUsersId(java.lang.String usersId){
        this.usersId = usersId;
    }
        
}