package com.harvey.vchat.bas.query;    

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import com.gsst.eaf.core.model.BaseItemClass;

/**
 * Query Item class for MenuRolesQuery
 */
@Entity
public class MenuRolesQueryItem extends BaseItemClass implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** MENU_UUID
    *MENU_UUID
    */ 
    private java.lang.String menuUuid;
    
    @Column(name = "MENU_UUID")
    public java.lang.String getMenuUuid(){
        return this.menuUuid;
    }
    
    public void setMenuUuid(java.lang.String menuUuid){
        this.menuUuid = menuUuid;
    }
    
    /** P_MENU_UUID
    *P_MENU_UUID
    */ 
    private java.lang.String pMenuUuid;
    
    @Column(name = "P_MENU_UUID")
    public java.lang.String getPMenuUuid(){
        return this.pMenuUuid;
    }
    
    public void setPMenuUuid(java.lang.String pMenuUuid){
        this.pMenuUuid = pMenuUuid;
    }
    
    /** MENU_NAME
    *MENU_NAME
    */ 
    private java.lang.String menuName;
    
    @Column(name = "MENU_NAME")
    public java.lang.String getMenuName(){
        return this.menuName;
    }
    
    public void setMenuName(java.lang.String menuName){
        this.menuName = menuName;
    }
    
    /** MENU_GRP_SEQ
    *MENU_GRP_SEQ
    */ 
    private java.lang.Long menuGrpSeq;
    
    @Column(name = "MENU_GRP_SEQ")
    public java.lang.Long getMenuGrpSeq(){
        return this.menuGrpSeq;
    }
    
    public void setMenuGrpSeq(java.lang.Long menuGrpSeq){
        this.menuGrpSeq = menuGrpSeq;
    }
    
    /** MENU_ITEM_SEQ
    *MENU_ITEM_SEQ
    */ 
    private java.lang.Long menuItemSeq;
    
    @Column(name = "MENU_ITEM_SEQ")
    public java.lang.Long getMenuItemSeq(){
        return this.menuItemSeq;
    }
    
    public void setMenuItemSeq(java.lang.Long menuItemSeq){
        this.menuItemSeq = menuItemSeq;
    }
    
    /** CHECKED
    *CHECKED
    */ 
    private java.lang.Boolean checked;
    
    @Column(name = "CHECKED")
    public java.lang.Boolean getChecked(){
        return this.checked;
    }
    
    public void setChecked(java.lang.Boolean checked){
        this.checked = checked;
    }
    
    private String iconCls;

    @Column(name = "ICON_CLS")
    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
    
}