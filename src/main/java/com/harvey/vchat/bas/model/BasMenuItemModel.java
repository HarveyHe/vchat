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
 * Model class for BAS_MENU_ITEM
 * 菜单项
 */
@Entity
@Table(name = "BAS_MENU_ITEM")
@DynamicInsert
@DynamicUpdate
public class BasMenuItemModel extends BaseModelClass implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
  
    /** SYS_MENU_ITEM_UUID
    *菜单项ID
    */ 
    private java.lang.String sysMenuItemUuid;
    
    @Column(name = "SYS_MENU_ITEM_UUID")
    @Id @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="org.hibernate.id.UUIDGenerator")
    public java.lang.String getSysMenuItemUuid(){
        return this.sysMenuItemUuid;
    }
    
    public void setSysMenuItemUuid(java.lang.String sysMenuItemUuid){
        this.sysMenuItemUuid = sysMenuItemUuid;
        super.addValidField("sysMenuItemUuid");
    }
    
  
    /** SYS_MENU_GROUP_UUID
    *一级菜单ID
    */ 
    private java.lang.String sysMenuGroupUuid;
    
    @Column(name = "SYS_MENU_GROUP_UUID")
    public java.lang.String getSysMenuGroupUuid(){
        return this.sysMenuGroupUuid;
    }
    
    public void setSysMenuGroupUuid(java.lang.String sysMenuGroupUuid){
        this.sysMenuGroupUuid = sysMenuGroupUuid;
        super.addValidField("sysMenuGroupUuid");
    }
    
  
    /** MENU_ITEM_SEQ
    *菜单排序号
    */ 
    private java.lang.Long menuItemSeq;
    
    @Column(name = "MENU_ITEM_SEQ")
    public java.lang.Long getMenuItemSeq(){
        return this.menuItemSeq;
    }
    
    public void setMenuItemSeq(java.lang.Long menuItemSeq){
        this.menuItemSeq = menuItemSeq;
        super.addValidField("menuItemSeq");
    }
    
  
    /** MENU_ITEM_CODE
    *菜单代码
    */ 
    private java.lang.String menuItemCode;
    
    @Column(name = "MENU_ITEM_CODE")
    public java.lang.String getMenuItemCode(){
        return this.menuItemCode;
    }
    
    public void setMenuItemCode(java.lang.String menuItemCode){
        this.menuItemCode = menuItemCode;
        super.addValidField("menuItemCode");
    }
    
  
    /** MENU_ITEM_NAME
    *菜单中文名
    */ 
    private java.lang.String menuItemName;
    
    @Column(name = "MENU_ITEM_NAME")
    public java.lang.String getMenuItemName(){
        return this.menuItemName;
    }
    
    public void setMenuItemName(java.lang.String menuItemName){
        this.menuItemName = menuItemName;
        super.addValidField("menuItemName");
    }
    
  
    /** MENU_ITEM_NAME_EN
    *菜单英文名
    */ 
    private java.lang.String menuItemNameEn;
    
    @Column(name = "MENU_ITEM_NAME_EN")
    public java.lang.String getMenuItemNameEn(){
        return this.menuItemNameEn;
    }
    
    public void setMenuItemNameEn(java.lang.String menuItemNameEn){
        this.menuItemNameEn = menuItemNameEn;
        super.addValidField("menuItemNameEn");
    }
    
  
    /** MENU_ITEM_URL
    *菜单链接
    */ 
    private java.lang.String menuItemUrl;
    
    @Column(name = "MENU_ITEM_URL")
    public java.lang.String getMenuItemUrl(){
        return this.menuItemUrl;
    }
    
    public void setMenuItemUrl(java.lang.String menuItemUrl){
        this.menuItemUrl = menuItemUrl;
        super.addValidField("menuItemUrl");
    }
    
  
    /** MENU_ITEM_ACTION
    *功能提交权限
    */ 
    private java.lang.String menuItemAction;
    
    @Column(name = "MENU_ITEM_ACTION")
    public java.lang.String getMenuItemAction(){
        return this.menuItemAction;
    }
    
    public void setMenuItemAction(java.lang.String menuItemAction){
        this.menuItemAction = menuItemAction;
        super.addValidField("menuItemAction");
    }
    
  
    /** CLASS_NAME
    *类 名称
    */ 
    private java.lang.String className;
    
    @Column(name = "CLASS_NAME")
    public java.lang.String getClassName(){
        return this.className;
    }
    
    public void setClassName(java.lang.String className){
        this.className = className;
        super.addValidField("className");
    }
    
  
    /** IS_DIALOG
    *是否对话框
    */ 
    private java.lang.Integer isDialog;
    
    @Column(name = "IS_DIALOG")
    public java.lang.Integer getIsDialog(){
        return this.isDialog;
    }
    
    public void setIsDialog(java.lang.Integer isDialog){
        this.isDialog = isDialog;
        super.addValidField("isDialog");
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