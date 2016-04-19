package com.harvey.vchat.bas.model;    

import java.io.Serializable;
import com.harvey.common.core.model.BaseModelClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

/**
 * Model class for BAS_ROLE_MENU_ITEM
 * 角色菜单项权限
 */
@Entity
@Table(name = "BAS_ROLE_MENU_ITEM")
@DynamicInsert
@DynamicUpdate
public class BasRoleMenuItemModel extends BaseModelClass implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
  
    /** ROLE_MENU_ITEM_UUID
    *角色菜单项权限UUID
    */ 
    private java.lang.Integer roleMenuItemUuid;
    
    @Column(name = "ROLE_MENU_ITEM_UUID")
    @SequenceGenerator(name="SEQ_BAS_ROLE_MENU_ITEM", sequenceName="SEQ_BAS_ROLE_MENU_ITEM")
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BAS_ROLE_MENU_ITEM")    
    public java.lang.Integer getRoleMenuItemUuid(){
        return this.roleMenuItemUuid;
    }
    
    public void setRoleMenuItemUuid(java.lang.Integer roleMenuItemUuid){
        this.roleMenuItemUuid = roleMenuItemUuid;
        super.addValidField("roleMenuItemUuid");
    }
    
  
    /** MENU_ITEM_UUID
    *菜单项UUID
    */ 
    private java.lang.String menuItemUuid;
    
    @Column(name = "MENU_ITEM_UUID")
    public java.lang.String getMenuItemUuid(){
        return this.menuItemUuid;
    }
    
    public void setMenuItemUuid(java.lang.String menuItemUuid){
        this.menuItemUuid = menuItemUuid;
        super.addValidField("menuItemUuid");
    }
    
  
    /** REMARK
    *备注
    */ 
    private java.lang.String remark;
    
    @Column(name = "REMARK")
    public java.lang.String getRemark(){
        return this.remark;
    }
    
    public void setRemark(java.lang.String remark){
        this.remark = remark;
        super.addValidField("remark");
    }
    
  
    /** STATUS
    *状态：ACTIVE - 有效； CANCEL - 作废
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
    
  
    /** CONTROL_WORD
    *控制字：默认0
    */ 
    private java.lang.String controlWord;
    
    @Column(name = "CONTROL_WORD")
    public java.lang.String getControlWord(){
        return this.controlWord;
    }
    
    public void setControlWord(java.lang.String controlWord){
        this.controlWord = controlWord;
        super.addValidField("controlWord");
    }
    
  
    /** REC_VER
    *并发访问控制
    */ 
    private java.lang.Long recVer;
    
    @Column(name = "REC_VER")
    public java.lang.Long getRecVer(){
        return this.recVer;
    }
    
    public void setRecVer(java.lang.Long recVer){
        this.recVer = recVer;
        super.addValidField("recVer");
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
    *修改人
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
    *修改时间
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
    
  
    /** ROLE_UUID
    *角色UUID
    */ 
    private java.lang.Integer roleUuid;
    
    @Column(name = "ROLE_UUID")
    public java.lang.Integer getRoleUuid(){
        return this.roleUuid;
    }
    
    public void setRoleUuid(java.lang.Integer roleUuid){
        this.roleUuid = roleUuid;
        super.addValidField("roleUuid");
    }
    
}