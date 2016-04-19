package com.harvey.vchat.bas.query;

import javax.persistence.Column;
import javax.persistence.Entity;



import com.gsst.eaf.core.model.BaseItemClass;


@Entity
public class CodeDefCodeValueQueryItem extends BaseItemClass {

	private String codeValue;

	@Column(name = "CODE_VALUE")
	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
		//addValidField("codeValue");
	}

}
