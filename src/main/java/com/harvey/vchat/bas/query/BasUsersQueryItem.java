package com.harvey.vchat.bas.query;

import javax.persistence.Column;
import javax.persistence.Entity;



import com.gsst.eaf.core.model.BaseItemClass;


@Entity
public class BasUsersQueryItem extends BaseItemClass {

	private String usersId;
	private String employeeNo;
	private String userName;
	private String userNameEn;
	private String departmentName;
	private String email;

	@Column(name = "USERS_ID")
	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
		//addValidField("usersId");
	}

	@Column(name = "EMPLOYEE_NO")
	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
		//addValidField("employeeNo");
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
		//addValidField("userName");
	}

	@Column(name = "USER_NAME_EN")
	public String getUserNameEn() {
		return userNameEn;
	}

	public void setUserNameEn(String userNameEn) {
		this.userNameEn = userNameEn;
		//addValidField("userNameEn");
	}

	@Column(name = "DEPARTMENT_NAME")
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
		//addValidField("departmentName");
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		//addValidField("email");
	}

}
