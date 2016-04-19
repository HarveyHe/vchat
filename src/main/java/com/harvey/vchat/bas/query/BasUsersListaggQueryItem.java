package com.harvey.vchat.bas.query;    

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import com.gsst.eaf.core.model.BaseItemClass;

/**
 * Query Item class for BasUsersListaggQuery
 */
@Entity
public class BasUsersListaggQueryItem extends BaseItemClass implements Serializable{

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
    
    /** SENSITIVE_PASSWORD
    *SENSITIVE_PASSWORD
    */ 
    private java.lang.String sensitivePassword;
    
    @Column(name = "SENSITIVE_PASSWORD")
    public java.lang.String getSensitivePassword(){
        return this.sensitivePassword;
    }
    
    public void setSensitivePassword(java.lang.String sensitivePassword){
        this.sensitivePassword = sensitivePassword;
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
    
    /** COMPANY_ID
    *COMPANY_ID
    */ 
    private java.lang.String companyId;
    
    @Column(name = "COMPANY_ID")
    public java.lang.String getCompanyId(){
        return this.companyId;
    }
    
    public void setCompanyId(java.lang.String companyId){
        this.companyId = companyId;
    }
    
    /** COMPANY_NAME
    *COMPANY_NAME
    */ 
    private java.lang.String companyName;
    
    @Column(name = "COMPANY_NAME")
    public java.lang.String getCompanyName(){
        return this.companyName;
    }
    
    public void setCompanyName(java.lang.String companyName){
        this.companyName = companyName;
    }
    
    /** COMPANY_SHORT_NAME
    *COMPANY_SHORT_NAME
    */ 
    private java.lang.String companyShortName;
    
    @Column(name = "COMPANY_SHORT_NAME")
    public java.lang.String getCompanyShortName(){
        return this.companyShortName;
    }
    
    public void setCompanyShortName(java.lang.String companyShortName){
        this.companyShortName = companyShortName;
    }
    
    /** DOMAIN_USER_NAME
    *DOMAIN_USER_NAME
    */ 
    private java.lang.String domainUserName;
    
    @Column(name = "DOMAIN_USER_NAME")
    public java.lang.String getDomainUserName(){
        return this.domainUserName;
    }
    
    public void setDomainUserName(java.lang.String domainUserName){
        this.domainUserName = domainUserName;
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
    /** IS_NEED_CONFIRM_PASSWORD
     *IS_NEED_CONFIRM_PASSWORD
     */ 
    private java.lang.String isNeedConfirmPassword;
    
    @Column(name = "IS_NEED_CONFIRM_PASSWORD")
    public java.lang.String getIsNeedConfirmPassword(){
    	return this.isNeedConfirmPassword;
    }
    
    public void setIsNeedConfirmPassword(java.lang.String isNeedConfirmPassword){
    	this.isNeedConfirmPassword = isNeedConfirmPassword;
    }
    /** EMP_GRADE
    *等级，经理及以上员工:职级除A,B,C外的员工;
    */ 
    private java.lang.String empGrade;
    
    @Column(name = "EMP_GRADE")
    public java.lang.String getEmpGrade(){
        return this.empGrade;
    }
    
    public void setEmpGrade(java.lang.String empGrade){
        this.empGrade = empGrade;
    }
}