package com.harvey.vchat.bas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.harvey.common.core.model.BaseModelClass;

/**
 * Model class for 数据字典表
 */
@Entity
@Table(name = "BAS_CODE_DEF")
@DynamicInsert
@DynamicUpdate
public class BasCodeDefModel extends BaseModelClass {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "BasCodeDef";

	public static final class FieldNames {
		/**
		 * 主键UUID
		 */
		public static final String basCodeDefUuid = "basCodeDefUuid";
		/**
		 * 类型UUID
		 */
		public static final String basCodeTypeUuid = "basCodeTypeUuid";
		/**
		 * 代码值
		 */
		public static final String codeValue = "codeValue";
		/**
		 * 代码数字值
		 */
		public static final String codeNumber = "codeNumber";
		/**
		 * 编码内容（中文）
		 */
		public static final String displayValue = "displayValue";
		/**
		 * 编码内容（英文）
		 */
		public static final String displayValueEn = "displayValueEn";
		/**
		 * 是否允许修改
		 */
		public static final String modifiable = "modifiable";
		/**
		 * 备注
		 */
		public static final String remark = "remark";
		/**
		 * 状态
		 */
		public static final String status = "status";
		/**
		 * 中心代码
		 */
		public static final String centerCode = "centerCode";
		/**
		 * 控制字
		 */
		public static final String controlWord = "controlWord";
		/**
		 * 公司（仓库）代码
		 */
		public static final String officeCode = "officeCode";
		/**
		 * 并发访问控制
		 */
		public static final String recVer = "recVer";
		/**
		 * 创建人
		 */
		public static final String creator = "creator";
		/**
		 * 创建时间
		 */
		public static final String createTime = "createTime";
		/**
		 * 修改人
		 */
		public static final String modifier = "modifier";
		/**
		 * 修改时间
		 */
		public static final String modifyTime = "modifyTime";
	}

	//主键UUID
	private String basCodeDefUuid;
	//类型UUID
	private String basCodeTypeUuid;
	//代码值
	private String codeValue;
	//代码数字值
	private Double codeNumber;
	//编码内容（中文）
	private String displayValue;
	//编码内容（英文）
	private String displayValueEn;
	//是否允许修改
	private Integer modifiable;
	//备注
	private String remark;
	//状态
	private String status;
	//中心代码
	private String centerCode;
	//控制字
	private String controlWord;
	//公司（仓库）代码
	private String officeCode;
	//并发访问控制
	private Long recVer;
	//创建人
	private String creator;
	//创建时间
	private Date createTime;
	//修改人
	private String modifier;
	//修改时间
	private Date modifyTime;

	/**
	 * Get 主键UUID
	 */
	@Column(name = "BAS_CODE_DEF_UUID")
    @GeneratedValue(generator="uuid")
    @Id @GenericGenerator(name="uuid",strategy="org.hibernate.id.UUIDGenerator")
	public String getBasCodeDefUuid() {
		return basCodeDefUuid;
	}

	/**
	 * Set 主键UUID
	 */
	public void setBasCodeDefUuid(String basCodeDefUuid) {
		this.basCodeDefUuid = basCodeDefUuid;
		addValidField(FieldNames.basCodeDefUuid);
	}

	/**
	 * Get 类型UUID
	 */
	@Column(name = "BAS_CODE_TYPE_UUID")
	public String getBasCodeTypeUuid() {
		return basCodeTypeUuid;
	}

	/**
	 * Set 类型UUID
	 */
	public void setBasCodeTypeUuid(String basCodeTypeUuid) {
		this.basCodeTypeUuid = basCodeTypeUuid;
		addValidField(FieldNames.basCodeTypeUuid);
	}

	/**
	 * Get 代码值
	 */
	@Column(name = "CODE_VALUE")
	public String getCodeValue() {
		return codeValue;
	}

	/**
	 * Set 代码值
	 */
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
		addValidField(FieldNames.codeValue);
	}

	/**
	 * Get 代码数字值
	 */
	@Column(name = "CODE_NUMBER")
	public Double getCodeNumber() {
		return codeNumber;
	}

	/**
	 * Set 代码数字值
	 */
	public void setCodeNumber(Double codeNumber) {
		this.codeNumber = codeNumber;
		addValidField(FieldNames.codeNumber);
	}

	/**
	 * Get 编码内容（中文）
	 */
	@Column(name = "DISPLAY_VALUE")
	public String getDisplayValue() {
		return displayValue;
	}

	/**
	 * Set 编码内容（中文）
	 */
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
		addValidField(FieldNames.displayValue);
	}

	/**
	 * Get 编码内容（英文）
	 */
	@Column(name = "DISPLAY_VALUE_EN")
	public String getDisplayValueEn() {
		return displayValueEn;
	}

	/**
	 * Set 编码内容（英文）
	 */
	public void setDisplayValueEn(String displayValueEn) {
		this.displayValueEn = displayValueEn;
		addValidField(FieldNames.displayValueEn);
	}

	/**
	 * Get 是否允许修改
	 */
	@Column(name = "MODIFIABLE")
	public Integer getModifiable() {
		return modifiable;
	}

	/**
	 * Set 是否允许修改
	 */
	public void setModifiable(Integer modifiable) {
		this.modifiable = modifiable;
		addValidField(FieldNames.modifiable);
	}

	/**
	 * Get 备注
	 */
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	/**
	 * Set 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
		addValidField(FieldNames.remark);
	}

	/**
	 * Get 状态
	 * ：ACTIVE - 有效； CANCEL - 作废
	 */
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	/**
	 * Set 状态
	 * ：ACTIVE - 有效； CANCEL - 作废
	 */
	public void setStatus(String status) {
		this.status = status;
		addValidField(FieldNames.status);
	}

	/**
	 * Get 中心代码
	 */
	@Column(name = "CENTER_CODE")
	public String getCenterCode() {
		return centerCode;
	}

	/**
	 * Set 中心代码
	 */
	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
		addValidField(FieldNames.centerCode);
	}

	/**
	 * Get 控制字
	 * ：默认0
	 */
	@Column(name = "CONTROL_WORD")
	public String getControlWord() {
		return controlWord;
	}

	/**
	 * Set 控制字
	 * ：默认0
	 */
	public void setControlWord(String controlWord) {
		this.controlWord = controlWord;
		addValidField(FieldNames.controlWord);
	}

	/**
	 * Get 公司（仓库）代码
	 */
	@Column(name = "OFFICE_CODE")
	public String getOfficeCode() {
		return officeCode;
	}

	/**
	 * Set 公司（仓库）代码
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
		addValidField(FieldNames.officeCode);
	}

	/**
	 * Get 并发访问控制
	 */
	@Column(name = "REC_VER")
	@Version
	public Long getRecVer() {
		return recVer;
	}

	/**
	 * Set 并发访问控制
	 */
	public void setRecVer(Long recVer) {
		this.recVer = recVer;
		addValidField(FieldNames.recVer);
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
	 * Get 修改人
	 */
	@Column(name = "MODIFIER")
	public String getModifier() {
		return modifier;
	}

	/**
	 * Set 修改人
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
		addValidField(FieldNames.modifier);
	}

	/**
	 * Get 修改时间
	 */
	@Column(name = "MODIFY_TIME")
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * Set 修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
		addValidField(FieldNames.modifyTime);
	}

}
