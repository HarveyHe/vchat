package com.harvey.vchat.bas.model;

import java.util.Date;

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
 * Model class for BasRoles
 */
@Entity
@Table(name = "BAS_ROLES")
@DynamicInsert
@DynamicUpdate
public class BasRolesModel extends BaseModelClass {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "BasRoles";

	public static final class FieldNames {
		/**
		 * roleId
		 */
		public static final String roleId = "roleId";
		/**
		 * 角色
		 */
		public static final String roleName = "roleName";
		/**
		 * 状态
		 */
		public static final String status = "status";
		/**
		 * 创建人
		 */
		public static final String creator = "creator";
		/**
		 * 创建时间
		 */
		public static final String createTime = "createTime";
		/**
		 * 更新人
		 */
		public static final String modifier = "modifier";
		/**
		 * 更新时间
		 */
		public static final String modifyTime = "modifyTime";
	}

	//roleId
	private String roleId;
	//角色
	private String roleName;
	//状态
	private String status;
	//创建人
	private String creator;
	//创建时间
	private Date createTime;
	//更新人
	private String modifier;
	//更新时间
	private Date modifyTime;

	/**
	 * Get roleId
	 */
	@Column(name = "ROLE_ID")
	@GeneratedValue(generator="uuid")
	@Id @GenericGenerator(name="uuid",strategy="org.hibernate.id.UUIDGenerator")
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
	 * Get 角色
	 */
	@Column(name = "ROLE_NAME")
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Set 角色
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
		addValidField(FieldNames.roleName);
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

	/**
	 * Get 创建人
	 */
	@Column(name = "CREATOR")
	public String getCreator() {
		return creator;
	}

	/**
	 * Set 创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
		addValidField(FieldNames.creator);
	}

	/**
	 * Get 创建时间
	 */
	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * Set 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		addValidField(FieldNames.createTime);
	}

	/**
	 * Get 更新人
	 */
	@Column(name = "MODIFIER")
	public String getModifier() {
		return modifier;
	}

	/**
	 * Set 更新人
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
		addValidField(FieldNames.modifier);
	}

	/**
	 * Get 更新时间
	 */
	@Column(name = "MODIFY_TIME")
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * Set 更新时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
		addValidField(FieldNames.modifyTime);
	}

}
