package com.harvey.vchat.bas.query;    

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import com.gsst.eaf.core.model.BaseItemClass;

/**
 * Query Item class for BasUsersWithDeptInfoQuery
 */
@Entity
public class BasUsersWithDeptInfoQueryItem extends BaseItemClass implements Serializable{

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
    
    /** USER_NAME_EN
    *USER_NAME_EN
    */ 
    private java.lang.String userNameEn;
    
    @Column(name = "USER_NAME_EN")
    public java.lang.String getUserNameEn(){
        return this.userNameEn;
    }
    
    public void setUserNameEn(java.lang.String userNameEn){
        this.userNameEn = userNameEn;
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
    
    /** EMP_GRADE
    *EMP_GRADE
    */ 
    private java.lang.String empGrade;
    
    @Column(name = "EMP_GRADE")
    public java.lang.String getEmpGrade(){
        return this.empGrade;
    }
    
    public void setEmpGrade(java.lang.String empGrade){
        this.empGrade = empGrade;
    }
    
    /** DEPARTMENT_SHORT_NAME
    *DEPARTMENT_SHORT_NAME
    */ 
    private java.lang.String departmentShortName;
    
    @Column(name = "DEPARTMENT_SHORT_NAME")
    public java.lang.String getDepartmentShortName(){
        return this.departmentShortName;
    }
    
    public void setDepartmentShortName(java.lang.String departmentShortName){
        this.departmentShortName = departmentShortName;
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
    
    /** USER_NAME_SHOW
    *USER_NAME_SHOW
    */ 
    private java.lang.String userNameShow;
    
    @Column(name = "USER_NAME_SHOW")
    public java.lang.String getUserNameShow(){
        return this.userNameShow;
    }
    
    public void setUserNameShow(java.lang.String userNameShow){
        this.userNameShow = userNameShow;
    }
    
}