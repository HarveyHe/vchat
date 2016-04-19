package com.harvey.vchat.bas.query;    

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import com.gsst.eaf.core.model.BaseItemClass;

/**
 * Query Item class for BasUsersRolesQuery
 */
@Entity
public class BasUsersRolesQueryItem extends BaseItemClass implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** USERS_ID
    *USERS_ID
    */ 
    private java.lang.String usersId;
    
    @Column(name = "USERS_ID")
    public java.lang.String getUsersId(){
        return this.usersId;
    }
    
    public void setUsersId(java.lang.String usersId){
        this.usersId = usersId;
    }
    
    /** USER_NAME
    *USER_NAME
    */ 
    private java.lang.String userName;
    
    @Column(name = "USER_NAME")
    public java.lang.String getUserName(){
        return this.userName;
    }
    
    public void setUserName(java.lang.String userName){
        this.userName = userName;
    }
    
    /** EMPLOYEE_NO
    *EMPLOYEE_NO
    */ 
    private java.lang.String employeeNo;
    
    @Column(name = "EMPLOYEE_NO")
    public java.lang.String getEmployeeNo(){
        return this.employeeNo;
    }
    
    public void setEmployeeNo(java.lang.String employeeNo){
        this.employeeNo = employeeNo;
    }
    
    /** DEPARTMENT_NAME
    *DEPARTMENT_NAME
    */ 
    private java.lang.String departmentName;
    
    @Column(name = "DEPARTMENT_NAME")
    public java.lang.String getDepartmentName(){
        return this.departmentName;
    }
    
    public void setDepartmentName(java.lang.String departmentName){
        this.departmentName = departmentName;
    }
    
    /** EMAIL
    *EMAIL
    */ 
    private java.lang.String email;
    
    @Column(name = "EMAIL")
    public java.lang.String getEmail(){
        return this.email;
    }
    
    public void setEmail(java.lang.String email){
        this.email = email;
    }
    
    /** FINANCE_APPROVAL_AMOUNT
    *FINANCE_APPROVAL_AMOUNT
    */ 
    private java.lang.Integer financeApprovalAmount;
    
    @Column(name = "FINANCE_APPROVAL_AMOUNT")
    public java.lang.Integer getFinanceApprovalAmount(){
        return this.financeApprovalAmount;
    }
    
    public void setFinanceApprovalAmount(java.lang.Integer financeApprovalAmount){
        this.financeApprovalAmount = financeApprovalAmount;
    }
    
    /** DATA_SCOPE
    *DATA_SCOPE
    */ 
    private java.lang.String dataScope;
    
    @Column(name = "DATA_SCOPE")
    public java.lang.String getDataScope(){
        return this.dataScope;
    }
    
    public void setDataScope(java.lang.String dataScope){
        this.dataScope = dataScope;
    }
    
    /** STATUS
    *STATUS
    */ 
    private java.lang.String status;
    
    @Column(name = "STATUS")
    public java.lang.String getStatus(){
        return this.status;
    }
    
    public void setStatus(java.lang.String status){
        this.status = status;
    }
    
    /** MODIFIER
    *MODIFIER
    */ 
    private java.lang.String modifier;
    
    @Column(name = "MODIFIER")
    public java.lang.String getModifier(){
        return this.modifier;
    }
    
    public void setModifier(java.lang.String modifier){
        this.modifier = modifier;
    }
    
    /** MODIFY_TIME
    *MODIFY_TIME
    */ 
    private java.util.Date modifyTime;
    
    @Column(name = "MODIFY_TIME")
    public java.util.Date getModifyTime(){
        return this.modifyTime;
    }
    
    public void setModifyTime(java.util.Date modifyTime){
        this.modifyTime = modifyTime;
    }
    
    /** ROLE_NAME
    *ROLE_NAME
    */ 
    private java.lang.String roleName;
    
    @Column(name = "ROLE_NAME")
    public java.lang.String getRoleName(){
        return this.roleName;
    }
    
    public void setRoleName(java.lang.String roleName){
        this.roleName = roleName;
    }
    
    /** ROLE_ID
    *ROLE_ID
    */ 
    private java.lang.String roleId;
    
    @Column(name = "ROLE_ID")
    public java.lang.String getRoleId(){
        return this.roleId;
    }
    
    public void setRoleId(java.lang.String roleId){
        this.roleId = roleId;
    }
    
    /** BAS_USERS_ROLES_ID
    *BAS_USERS_ROLES_ID
    */ 
    private java.lang.String basUsersRolesId;
    
    @Column(name = "BAS_USERS_ROLES_ID")
    public java.lang.String getBasUsersRolesId(){
        return this.basUsersRolesId;
    }
    
    public void setBasUsersRolesId(java.lang.String basUsersRolesId){
        this.basUsersRolesId = basUsersRolesId;
    }
    
    /** USERS_ROLES_STATS
    *USERS_ROLES_STATS
    */ 
    private java.lang.String usersRolesStats;
    
    @Column(name = "USERS_ROLES_STATS")
    public java.lang.String getUsersRolesStats(){
        return this.usersRolesStats;
    }
    
    public void setUsersRolesStats(java.lang.String usersRolesStats){
        this.usersRolesStats = usersRolesStats;
    }
    
}