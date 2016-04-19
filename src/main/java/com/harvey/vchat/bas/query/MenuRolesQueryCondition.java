package com.harvey.vchat.bas.query;   

import java.io.Serializable;

/**
 * Query Condition class for MenuRolesQuery
 */
public class MenuRolesQueryCondition implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}