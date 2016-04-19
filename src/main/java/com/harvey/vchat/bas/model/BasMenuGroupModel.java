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
 * Model class for BAS_MENU_GROUP
 * 菜单分组
 */
@Entity
@Table(name = "BAS_MENU_GROUP")
@DynamicInsert
@DynamicUpdate
public class BasMenuGroupModel extends BaseModelClass implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
  
    /** SYS_MENU_GROUP_UUID
    *一级菜单UUID
    */ 
    private java.lang.String sysMenuGroupUuid;
    
    @Column(name = "SYS_MENU_GROUP_UUID")
    @Id @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="org.hibernate.id.UUIDGenerator")
    public java.lang.String getSysMenuGroupUuid(){
        return this.sysMenuGroupUuid;
    }
    
    public void setSysMenuGroupUuid(java.lang.String sysMenuGroupUuid){
        this.sysMenuGroupUuid = sysMenuGroupUuid;
        super.addValidField("sysMenuGroupUuid");
    }
    
  
    /** SYS_MODULE_UUID
    *模块UUID
    */ 
    private java.lang.String sysModuleUuid;
    
    @Column(name = "SYS_MODULE_UUID")
    public java.lang.String getSysModuleUuid(){
        return this.sysModuleUuid;
    }
    
    public void setSysModuleUuid(java.lang.String sysModuleUuid){
        this.sysModuleUuid = sysModuleUuid;
        super.addValidField("sysModuleUuid");
    }
    
  
    /** PRE_SYS_MENU_GROUP_UUID
    *
    */ 
    private java.lang.String preSysMenuGroupUuid;
    
    @Column(name = "PRE_SYS_MENU_GROUP_UUID")
    public java.lang.String getPreSysMenuGroupUuid(){
        return this.preSysMenuGroupUuid;
    }
    
    public void setPreSysMenuGroupUuid(java.lang.String preSysMenuGroupUuid){
        this.preSysMenuGroupUuid = preSysMenuGroupUuid;
        super.addValidField("preSysMenuGroupUuid");
    }
    
  
    /** MENU_GRP_SEQ
    *菜单组序号
    */ 
    private java.lang.Long menuGrpSeq;
    
    @Column(name = "MENU_GRP_SEQ")
    public java.lang.Long getMenuGrpSeq(){
        return this.menuGrpSeq;
    }
    
    public void setMenuGrpSeq(java.lang.Long menuGrpSeq){
        this.menuGrpSeq = menuGrpSeq;
        super.addValidField("menuGrpSeq");
    }
    
  
    /** MENU_GRP_CODE
    *菜单分组代码
    */ 
    private java.lang.String menuGrpCode;
    
    @Column(name = "MENU_GRP_CODE")
    public java.lang.String getMenuGrpCode(){
        return this.menuGrpCode;
    }
    
    public void setMenuGrpCode(java.lang.String menuGrpCode){
        this.menuGrpCode = menuGrpCode;
        super.addValidField("menuGrpCode");
    }
    
  
    /** MENU_GRP_NAME
    *菜单分组中文名
    */ 
    private java.lang.String menuGrpName;
    
    @Column(name = "MENU_GRP_NAME")
    public java.lang.String getMenuGrpName(){
        return this.menuGrpName;
    }
    
    public void setMenuGrpName(java.lang.String menuGrpName){
        this.menuGrpName = menuGrpName;
        super.addValidField("menuGrpName");
    }
    
  
    /** MENU_GRP_NAME_EN
    *菜单分组英文名
    */ 
    private java.lang.String menuGrpNameEn;
    
    @Column(name = "MENU_GRP_NAME_EN")
    public java.lang.String getMenuGrpNameEn(){
        return this.menuGrpNameEn;
    }
    
    public void setMenuGrpNameEn(java.lang.String menuGrpNameEn){
        this.menuGrpNameEn = menuGrpNameEn;
        super.addValidField("menuGrpNameEn");
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
    
  
    /** ICON_CLS
    *图标
    */ 
    private java.lang.String iconCls;
    
    @Column(name = "ICON_CLS")
    public java.lang.String getIconCls(){
        return this.iconCls;
    }
    
    public void setIconCls(java.lang.String iconCls){
        this.iconCls = iconCls;
        super.addValidField("iconCls");
    }
    
  
    /** VISIBLE
    *是否可见
    */ 
    private java.lang.Integer visible;
    
    @Column(name = "VISIBLE")
    public java.lang.Integer getVisible(){
        return this.visible;
    }
    
    public void setVisible(java.lang.Integer visible){
        this.visible = visible;
        super.addValidField("visible");
    }
    
}