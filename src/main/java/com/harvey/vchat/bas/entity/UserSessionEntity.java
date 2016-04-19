package com.harvey.vchat.bas.entity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;

import com.harvey.common.core.model.UserBaseModel;
import com.harvey.vchat.bas.model.BasUsersModel;

public class UserSessionEntity extends BasUsersModel implements UserBaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String userLevel;
    private List<? extends GrantedAuthority> authorities;
    
    private String isValidatedSensitivePassword;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    public void setAuthorities(List<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Map<Object, Object> getAttribute() {
        return null;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

	public String getIsValidatedSensitivePassword() {
		return isValidatedSensitivePassword;
	}

	public void setIsValidatedSensitivePassword(String isValidatedSensitivePassword) {
		this.isValidatedSensitivePassword = isValidatedSensitivePassword;
	}

}
