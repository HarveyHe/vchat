package com.harvey.vchat.bas.model;

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
 * Model class for BasUsersRoles
 */
@Entity
@Table(name = "BAS_USERS_ROLES")
@DynamicInsert
@DynamicUpdate
public class BasUsersRolesModel extends BaseModelClass {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "BasUsersRoles";

	public static final class FieldNames {
		/**
		 * basUsersRolesId
		 */
		public static final String basUsersRolesId = "basUsersRolesId";
		/**
		 * roleId
		 */
		public static final String roleId = "roleId";
		/**
		 * userId
		 */
		public static final String userId = "userId";
		/**
		 * 状态
		 */
		public static final String status = "status";
	}

	//basUsersRolesId
	private String basUsersRolesId;
	//roleId
	private String roleId;
	//userId
	private String userId;
	//状态
	private String status;

	/**
	 * Get basUsersRolesId
	 */
	@Column(name = "BAS_USERS_ROLES_ID")
    @GeneratedValue(generator="uuid")
    @Id @GenericGenerator(name="uuid",strategy="org.hibernate.id.UUIDGenerator")
	public String getBasUsersRolesId() {
		return basUsersRolesId;
	}

	/**
	 * Set basUsersRolesId
	 */
	public void setBasUsersRolesId(String basUsersRolesId) {
		this.basUsersRolesId = basUsersRolesId;
		addValidField(FieldNames.basUsersRolesId);
	}

	/**
	 * Get roleId
	 */
	@Column(name = "ROLE_ID")
	public String getRoleId() {
		return roleId;
	}

	/**
	 * Set roleId
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
		addValidField(FieldNames.roleId);
	}

	/**
	 * Get userId
	 */
	@Column(name = "USER_ID")
	public String getUserId() {
		return userId;
	}

	/**
	 * Set userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
		addValidField(FieldNames.userId);
	}

	/**
	 * Get 状态
	 */
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	/**
	 * Set 状态
	 */
	public void setStatus(String status) {
		this.status = status;
		addValidField(FieldNames.status);
	}

}
