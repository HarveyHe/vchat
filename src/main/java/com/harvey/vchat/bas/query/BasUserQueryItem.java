package com.harvey.vchat.bas.query;

import javax.persistence.Column;
import javax.persistence.Entity;



import com.gsst.eaf.core.model.BaseItemClass;


@Entity
public class BasUserQueryItem extends BaseItemClass {

	private String employeeNo;

	@Column(name = "EMPLOYEE_NO")
	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
		//addValidField("employeeNo");
	}

}
