package com.harvey.vchat.bas.query;

import javax.persistence.Column;
import javax.persistence.Entity;



import com.gsst.eaf.core.model.BaseItemClass;


@Entity
public class CodeDefSelectCodeQueryItem extends BaseItemClass {

	private String typeCode;
	private String codeValue;
	private String displayValue;
	private String displayValueEn;
	private Double codeNumber;
	private String controlWord;

	@Column(name = "TYPE_CODE")
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
		//addValidField("typeCode");
	}

	@Column(name = "CODE_VALUE")
	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
		//addValidField("codeValue");
	}

	@Column(name = "DISPLAY_VALUE")
	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
		//addValidField("displayValue");
	}

	@Column(name = "DISPLAY_VALUE_EN")
	public String getDisplayValueEn() {
		return displayValueEn;
	}

	public void setDisplayValueEn(String displayValueEn) {
		this.displayValueEn = displayValueEn;
		//addValidField("displayValueEn");
	}

	@Column(name = "CODE_NUMBER")
	public Double getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(Double codeNumber) {
		this.codeNumber = codeNumber;
		//addValidField("codeNumber");
	}

	@Column(name = "CONTROL_WORD")
	public String getControlWord() {
		return controlWord;
	}

	public void setControlWord(String controlWord) {
		this.controlWord = controlWord;
		//addValidField("controlWord");
	}

}
