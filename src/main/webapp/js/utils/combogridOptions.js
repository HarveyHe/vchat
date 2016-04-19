var COMBOGRID_OPTIONS = {
/*
	ALL_USERS : {
		columns : [ {
			field : "userCode"
		}, {
			field : "userName"
		}, {
			field : "middleName"
		} ],
		i18nRoot : "SysUser"
	},
*/
		DEPARTMENT : {
			columns : [ {
				field : "departmentName",
				title:"部门名称",
				width : 170
			}, {
				field : "departmentShortName",
				title:"部门简称",
				width : 80
			}],
			i18nRoot : "Customer"
		},
		
		DEPARTMENT_NAME : {
			columns : [ {
				field : "departmentName",
				title:"部门名称",
				width : 170
			}, {
				field : "departmentShortName",
				title:"部门简称",
				width : 80
			}],
			i18nRoot : "Customer"
		},
		
		COMPANY_PAYMENT_SHORT_NAME : {
			columns : [ {
				field : "companyName",
				title:"公司中文全称",
				width : 170
			}, {
				field : "companyShortName",
				title:"公司简称",
				width : 80
			}, {
				field : "companyCode",
				title:"公司代码",
				width : 80
			} ],
			i18nRoot : "Customer"
		},
		COMPANY_PAYMENT : {
			columns : [ {
				field : "companyName",
				title:"公司中文全称",
				width : 170
			}, {
				field : "companyShortName",
				title:"公司简称",
				width : 80
			}, {
				field : "companyCode",
				title:"公司代码",
				width : 80
			} ],
			i18nRoot : "Customer"
		},
		COMPANY : {
			columns : [ {
				field : "companyName",
				title:"公司中文全称",
				width : 170
			}, {
				field : "companyShortName",
				title:"公司简称",
				width : 80
			}, {
				field : "companyCode",
				title:"公司代码",
				width : 80
			} ],
			i18nRoot : "Customer"
		},
		COMPANY_ID : {
			columns : [ {
				field : "companyName",
				title:"公司中文全称",
				width : 170
			}, {
				field : "companyShortName",
				title:"公司简称",
				width : 80
			}, {
				field : "companyCode",
				title:"公司代码",
				width : 80
			} ],
			i18nRoot : "Customer"
		},
		COMPANY_ID_SHORT_NAME : {
			columns : [ {
				field : "companyName",
				title:"公司中文全称",
				width : 170
			}, {
				field : "companyShortName",
				title:"公司简称",
				width : 80
			}, {
				field : "companyCode",
				title:"公司代码",
				width : 80
			} ],
			i18nRoot : "Customer"
		},
		COMPANY_SHORT_NAME : {
			columns : [ {
				field : "companyName",
				title:"公司中文全称",
				width : 170
			}, {
				field : "companyShortName",
				title:"公司简称",
				width : 80
			}, {
				field : "companyCode",
				title:"公司代码",
				width : 80
			} ],
			i18nRoot : "Customer"
		},
		COMPANY_SHORT_NAME_NORMAL : {
			columns : [ {
				field : "companyName",
				title:"公司中文全称",
				width : 200
			}, {
				field : "companyShortName",
				title:"公司简称",
				width : 80
			}, {
				field : "companyCode",
				title:"公司代码",
				width : 80
			} ],
			i18nRoot : "Customer"
		},
		COMPANY_STATUS_NORMAL : {
			columns : [ {
				field : "companyName",
				title:"公司中文全称",
				width : 170
			}, {
				field : "companyShortName",
				title:"公司简称",
				width : 80
			}, {
				field : "companyCode",
				title:"公司代码",
				width : 80
			} ],
			i18nRoot : "Customer"
		},
		
		EMPLOYEE_CFO : {
			columns : [ {
				field : "employeeNo",
				title:"工号",
				width : 80
			}, {
				field : "userName",
				title:"姓名",
				width : 80
			}, {
				field : "userNameEn",
				title:"英文名",
				width : 80
			} ],
			i18nRoot : "Customer"
		},
		EMPLOYEE : {
			columns : [ {
				field : "employeeNo",
				title:"工号",
				width : 80
			}, {
				field : "userName",
				title:"姓名",
				width : 80
			}, {
				field : "userNameEn",
				title:"英文名",
				width : 80
			} ],
			i18nRoot : "Customer"
		},
		EMPLOYEE_NO : {
			columns : [ {
				field : "employeeNo",
				title:"工号",
				width : 80
			}, {
				field : "userName",
				title:"姓名",
				width : 80
			}, {
				field : "userNameEn",
				title:"英文名",
				width : 80
			} ],
			i18nRoot : "Customer"
		},
		
		EMPLOYEE_MANAGER : {
			columns : [ {
				field : "employeeNo",
				title:"工号",
				width : 80
			}, {
				field : "userName",
				title:"姓名",
				width : 80
			}, {
				field : "departmentName",
				title:"英文名",
				width : 80
			} ],
			i18nRoot : "Customer"
		},
		
		SUBJECT : {
			columns : [ {
				field : "subjectName",
				title:"科目名称",
				width : 80
			}, {
				field : "subjectValue",
				title:"科目值",
				width : 80
			}],
			i18nRoot : "Customer"
		},
		
		EMPLOYEE_SELECT_APPROVER : {
			columns : [ {
				field : "departmentName",
				title:"部门"
			},{
				field : "departmentShortName",
				title:"部门简称"
			},{
				field : "employeeNo",
				title : "工号"
			},{
				field : "userName",
				title : "姓名"
			},{
				field : "userNameEn",
				title : "英文名"
			}]
		},
		
		EMPLOYEE_SELECT_GRADE : {
			columns : [ {
				field : "departmentName",
				title:"部门"
			},{
				field : "employeeNo",
				title : "工号"
			},{
				field : "userName",
				title : "姓名"
			},{
				field : "userNameEn",
				title : "英文名"
			}]
		},
		EMPLOYEE_SELECT_EO : {
			columns : [ {
				field : "departmentName",
				title:"部门"
			},{
				field : "employeeNo",
				title : "工号"
			},{
				field : "userName",
				title : "姓名"
			},{
				field : "userNameEn",
				title : "英文名"
			}]
		},
		ACCOUNTING_SUBJECT : {
			columns : [{
				field : "accountSubjectId",
				title : "ID"
			}]
		}
};
