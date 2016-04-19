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
 * Model class for BasSerialNumber
 */
@Entity
@Table(name = "BAS_SERIAL_NUMBER")
@DynamicInsert
@DynamicUpdate
public class BasSerialNumberModel extends BaseModelClass {

	private static final long serialVersionUID = 1L;

	public static final String MODEL_NAME = "BasSerialNumber";

	public static final class FieldNames {
		/**
		 * serialNumberId
		 */
		public static final String serialNumberId = "serialNumberId";
		/**
		 * 流水号类别
		 */
		public static final String type = "type";
		/**
		 * 流水号
		 */
		public static final String serialNo = "serialNo";
	}

	//serialNumberId
	private String serialNumberId;
	//流水号类别
	private String type;
	//流水号
	private String serialNo;

	/**
	 * Get serialNumberId
	 */
	@Column(name = "SERIAL_NUMBER_ID")
    @GeneratedValue(generator="uuid")
    @Id @GenericGenerator(name="uuid",strategy="org.hibernate.id.UUIDGenerator")
	public String getSerialNumberId() {
		return serialNumberId;
	}

	/**
	 * Set serialNumberId
	 */
	public void setSerialNumberId(String serialNumberId) {
		this.serialNumberId = serialNumberId;
		addValidField(FieldNames.serialNumberId);
	}

	/**
	 * Get 流水号类别
	 */
	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	/**
	 * Set 流水号类别
	 */
	public void setType(String type) {
		this.type = type;
		addValidField(FieldNames.type);
	}

	/**
	 * Get 流水号
	 */
	@Column(name = "SERIAL_NO")
	public String getSerialNo() {
		return serialNo;
	}

	/**
	 * Set 流水号
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
		addValidField(FieldNames.serialNo);
	}

}
