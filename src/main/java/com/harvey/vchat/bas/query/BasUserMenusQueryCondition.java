package com.harvey.vchat.bas.query;   

import java.io.Serializable;

/**
 * Query Condition class for BasUserMenusQuery
 */
public class BasUserMenusQueryCondition implements Serializable{
    
    private static final long serialVersionUID = 1L;
    

    private java.lang.String userId;
    
    public java.lang.String getUserId(){
        return this.userId;
    }
    
    public void setUserId(java.lang.String userId){
        this.userId = userId;
    }
        
}