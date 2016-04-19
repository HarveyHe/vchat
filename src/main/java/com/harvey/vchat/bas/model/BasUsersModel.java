package com.harvey.vchat.bas.model;    

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.harvey.common.core.model.BaseModelClass;

/**
 * Model class for BAS_USERS
 * 用户表 员工表
 */
@Entity
@Table(name = "BAS_USERS")
@DynamicInsert
@DynamicUpdate
public class BasUsersModel extends BaseModelClass implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
  
    /** USERS_ID
    *
    */ 
    private java.lang.String usersId;
    
    @Column(name = "USERS_ID")
    @Id @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="org.hibernate.id.UUIDGenerator")
    public java.lang.String getUsersId(){
        return this.usersId;
    }
    
    public void setUsersId(java.lang.String usersId){
        this.usersId = usersId;
        super.addValidField("usersId");
    }
    
  
    /** EMPLOYEE_NO
    *工号
    */ 
    private java.lang.String employeeNo;
    
    @Column(name = "EMPLOYEE_NO")
    public java.lang.String getEmployeeNo(){
        return this.employeeNo;
    }
    
    public void setEmployeeNo(java.lang.String employeeNo){
        this.employeeNo = employeeNo;
        super.addValidField("employeeNo");
    }
    
  
    /** USER_NAME
    *姓名
    */ 
    private java.lang.String userName;
    
    @Column(name = "USER_NAME")
    public java.lang.String getUserName(){
        return this.userName;
    }
    
    public void setUserName(java.lang.String userName){
        this.userName = userName;
        super.addValidField("userName");
    }
    
  
    /** DEPARTMENT_NAME
    *部门
    */ 
    private java.lang.String departmentName;
    
    @Column(name = "DEPARTMENT_NAME")
    public java.lang.String getDepartmentName(){
        return this.departmentName;
    }
    
    public void setDepartmentName(java.lang.String departmentName){
        this.departmentName = departmentName;
        super.addValidField("departmentName");
    }
    
  
    /** EMAIL
    *邮箱
    */ 
    private java.lang.String email;
    
    @Column(name = "EMAIL")
    public java.lang.String getEmail(){
        return this.email;
    }
    
    public void setEmail(java.lang.String email){
        this.email = email;
        super.addValidField("email");
    }
    
  
    /** PASSWORD
    *密码
    */ 
    private java.lang.String password;
    
    @Column(name = "PASSWORD")
    public java.lang.String getPassword(){
        return this.password;
    }
    
    public void setPassword(java.lang.String password){
        this.password = password;
        super.addValidField("password");
    }
    
  
    /** FINANCE_APPROVAL_AMOUNT
    *财务主管审批金额
    */ 
    private java.lang.Integer financeApprovalAmount;
    
    @Column(name = "FINANCE_APPROVAL_AMOUNT")
    public java.lang.Integer getFinanceApprovalAmount(){
        return this.financeApprovalAmount;
    }
    
    public void setFinanceApprovalAmount(java.lang.Integer financeApprovalAmount){
        this.financeApprovalAmount = financeApprovalAmount;
        super.addValidField("financeApprovalAmount");
    }
    
  
    /** DATA_SCOPE
    *数据范围
    */ 
    private java.lang.String dataScope;
    
    @Column(name = "DATA_SCOPE")
    public java.lang.String getDataScope(){
        return this.dataScope;
    }
    
    public void setDataScope(java.lang.String dataScope){
        this.dataScope = dataScope;
        super.addValidField("dataScope");
    }
    
  
    /** STATUS
    *状态
    */ 
    private java.lang.String status;
    
    @Column(name = "STATUS")
    public java.lang.String getStatus(){
        return this.status;
    }
    
    public void setStatus(java.lang.String status){
        this.status = status;
        super.addValidField("status");
    }
    
  
    /** SENSITIVE_PASSWORD
    *敏感信息二次密码
    */ 
    private java.lang.String sensitivePassword;
    
    @Column(name = "SENSITIVE_PASSWORD")
    public java.lang.String getSensitivePassword(){
        return this.sensitivePassword;
    }
    
    public void setSensitivePassword(java.lang.String sensitivePassword){
        this.sensitivePassword = sensitivePassword;
        super.addValidField("sensitivePassword");
    }
    
  
    /** CREATOR
    *创建人
    */ 
    private java.lang.String creator;
    
    @Column(name = "CREATOR")
    public java.lang.String getCreator(){
        return this.creator;
    }
    
    public void setCreator(java.lang.String creator){
        this.creator = creator;
        super.addValidField("creator");
    }
    
  
    /** CREATE_TIME
    *创建时间
    */ 
    private java.util.Date createTime;
    
    @Column(name = "CREATE_TIME")
    public java.util.Date getCreateTime(){
        return this.createTime;
    }
    
    public void setCreateTime(java.util.Date createTime){
        this.createTime = createTime;
        super.addValidField("createTime");
    }
    
  
    /** MODIFIER
    *更新人
    */ 
    private java.lang.String modifier;
    
    @Column(name = "MODIFIER")
    public java.lang.String getModifier(){
        return this.modifier;
    }
    
    public void setModifier(java.lang.String modifier){
        this.modifier = modifier;
        super.addValidField("modifier");
    }
    
  
    /** MODIFY_TIME
    *更新时间
    */ 
    private java.util.Date modifyTime;
    
    @Column(name = "MODIFY_TIME")
    public java.util.Date getModifyTime(){
        return this.modifyTime;
    }
    
    public void setModifyTime(java.util.Date modifyTime){
        this.modifyTime = modifyTime;
        super.addValidField("modifyTime");
    }
    
  
    /** USER_NAME_EN
    *英文名
    */ 
    private java.lang.String userNameEn;
    
    @Column(name = "USER_NAME_EN")
    public java.lang.String getUserNameEn(){
        return this.userNameEn;
    }
    
    public void setUserNameEn(java.lang.String userNameEn){
        this.userNameEn = userNameEn;
        super.addValidField("userNameEn");
    }
    
  
    /** COMPANY_ID
    *公司id
    */ 
    private java.lang.String companyId;
    
    @Column(name = "COMPANY_ID")
    public java.lang.String getCompanyId(){
        return this.companyId;
    }
    
    public void setCompanyId(java.lang.String companyId){
        this.companyId = companyId;
        super.addValidField("companyId");
    }
    
  
    /** COMPANY_NAME
    *公司名称
    */ 
    private java.lang.String companyName;
    
    @Column(name = "COMPANY_NAME")
    public java.lang.String getCompanyName(){
        return this.companyName;
    }
    
    public void setCompanyName(java.lang.String companyName){
        this.companyName = companyName;
        super.addValidField("companyName");
    }
    
  
    /** COMPANY_SHORT_NAME
    *公司简称
    */ 
    private java.lang.String companyShortName;
    
    @Column(name = "COMPANY_SHORT_NAME")
    public java.lang.String getCompanyShortName(){
        return this.companyShortName;
    }
    
    public void setCompanyShortName(java.lang.String companyShortName){
        this.companyShortName = companyShortName;
        super.addValidField("companyShortName");
    }
    
  
    /** DOMAIN_USER_NAME
    *域用户名
    */ 
    private java.lang.String domainUserName;
    
    @Column(name = "DOMAIN_USER_NAME")
    public java.lang.String getDomainUserName(){
        return this.domainUserName;
    }
    
    public void setDomainUserName(java.lang.String domainUserName){
        this.domainUserName = domainUserName;
        super.addValidField("domainUserName");
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
        super.addValidField("empGrade");
    }
    
  
    /** IS_NEED_CONFIRM_PASSWORD
    *是否需要验证二次密码
    */ 
    private java.lang.String isNeedConfirmPassword;
    
    @Column(name = "IS_NEED_CONFIRM_PASSWORD")
    public java.lang.String getIsNeedConfirmPassword(){
        return this.isNeedConfirmPassword;
    }
    
    public void setIsNeedConfirmPassword(java.lang.String isNeedConfirmPassword){
        this.isNeedConfirmPassword = isNeedConfirmPassword;
        super.addValidField("isNeedConfirmPassword");
    }
    
}