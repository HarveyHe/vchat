package com.harvey.vchat.bas.query;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;



import com.gsst.eaf.core.model.BaseItemClass;


@Entity
public class CodeTypeQueryItem extends BaseItemClass {

	private String basCodeTypeUuid;
	private String typeCode;
	private String typeName;
	private Integer typeGrade;
	private Long typeWidth;
	private String typeDesc;
	private String dataType;
	private String remark;
	private String status;
	private String centerCode;
	private String controlWord;
	private String officeCode;
	private Long recVer;
	private String creator;
	private Date createTime;
	private String modifier;
	private Date modifyTime;

	@Column(name = "BAS_CODE_TYPE_UUID")
	public String getBasCodeTypeUuid() {
		return basCodeTypeUuid;
	}

	public void setBasCodeTypeUuid(String basCodeTypeUuid) {
		this.basCodeTypeUuid = basCodeTypeUuid;
		//addValidField("basCodeTypeUuid");
	}

	@Column(name = "TYPE_CODE")
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
		//addValidField("typeCode");
	}

	@Column(name = "TYPE_NAME")
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
		//addValidField("typeName");
	}

	@Column(name = "TYPE_GRADE")
	public Integer getTypeGrade() {
		return typeGrade;
	}

	public void setTypeGrade(Integer typeGrade) {
		this.typeGrade = typeGrade;
		//addValidField("typeGrade");
	}

	@Column(name = "TYPE_WIDTH")
	public Long getTypeWidth() {
		return typeWidth;
	}

	public void setTypeWidth(Long typeWidth) {
		this.typeWidth = typeWidth;
		//addValidField("typeWidth");
	}

	@Column(name = "TYPE_DESC")
	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
		//addValidField("typeDesc");
	}

	@Column(name = "DATA_TYPE")
	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
		//addValidField("dataType");
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
		//addValidField("remark");
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		//addValidField("status");
	}

	@Column(name = "CENTER_CODE")
	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
		//addValidField("centerCode");
	}

	@Column(name = "CONTROL_WORD")
	public String getControlWord() {
		return controlWord;
	}

	public void setControlWord(String controlWord) {
		this.controlWord = controlWord;
		//addValidField("controlWord");
	}

	@Column(name = "OFFICE_CODE")
	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
		//addValidField("officeCode");
	}

	@Column(name = "REC_VER")
	public Long getRecVer() {
		return recVer;
	}

	public void setRecVer(Long recVer) {
		this.recVer = recVer;
		//addValidField("recVer");
	}

	@Column(name = "CREATOR")
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
		//addValidField("creator");
	}

	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		//addValidField("createTime");
	}

	@Column(name = "MODIFIER")
	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
		//addValidField("modifier");
	}

	@Column(name = "MODIFY_TIME")
	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
		//addValidField("modifyTime");
	}

}
