package com.harvey.vchat.common;

import java.util.HashMap;
import java.util.Map;


public class Constants {
	
	public final static class status {
		
		public final static String ACTIVE = "ACTIVE";
		
		public final static String CANCEL = "CANCEL";
		
		public final static String NORMAL = "NORMAL";

		public final static String DISABLED = "DISABLE";
		
		public final static String Y = "Y";
		public final static String N = "N";
		
		public final static String SUCCESS = "SUCCESS";
		public final static String FAIL = "FAIL";
		
		public final static String AGREE = "AGREE";
		public final static String AGREE_CHINESE = "同意";
		public final static String DISAGREE = "DISAGREE";
		public final static String DISAGREE_CHINESE = "不同意";
		
	}
	
	public final static class company {
		
		public final static String COMPANY_CODE_YICT = "YICT";	//盐田国际代码
		public final static String COMPANY_CODE_P3A = "P3A";	//盐田三期代码
		public final static String COMPANY_CODE_PML = "PML";	//平盐海铁联运代码
	}
	
	public final static class system {
		
		public final static String SYSTEM = "SYSTEM";
	}
	
	/**
	 * 单据类型：报销（E），借款（O）
	 * @author Admin
	 *
	 */
	public final static class billType {
		
		public final static String REIMBURSEMENT = "E";
		
		public final static String BORROW = "O";
		
	}
	
	/**
	 * 审批类型
	 * @author 
	 *
	 */
	public final static class ApprovalType{
		
		public final static String DEPARTMENT	 = "DEPARTMENT";  //部门审批
		public final static String CASHIER	 = "CASHIER";	//财务审核
		public final static String TREASURER	 = "TREASURER";//财务主管审核
	}
	
	/**
	 * 击审批类型
	 * @author 
	 *
	 */
	public final static class DocApprovalType{
		
		public static final String BORROWING_BILL = "A"; //借款单
		public static final String REIMBURSEMENT_BILL = "R"; //报销单
	}
	/**
	 * 会计科目单据类型
	 * @author 
	 *
	 */
	public final static class AccountSubjectType{
		
		public static final String BORROWING_BILL = "LOAN"; //借款单
		public static final String REIMBURSEMENT_BILL = "REIMBURSEMENT"; //报销单
	}
	public final static class BankName{
		
		public static final String BOC = "BOC"; 
		public static final String ICBC = "ICBC";
		public static final String BOC_CN = "中国银行";
		public static final String ICBC_CN = "中国工商银行";
	}
	
	
	public final static class ActivitiBillType {
		
		public static final String BORROWING_BILL = "borrowingBill"; //借款单
		public static final String REIMBURSEMENT_BILL = "reimbursementBill"; //报销单
														
	}
	
	
	public final static class borrowStatus {
		public static final String DRAFT="DRAFT";		//草稿
		public static final String DEPT_APPROVE="DEPT_APPROVE";		//用户部门批准
		public static final String FINANCIAL_DEPARTMENT_AUDIT="FINANCIAL_DEPT_AUDIT";		//财务部门审核
		public static final String REJECT="REJECT";		//拒绝
		public static final String ACCEPT="ACCEPT";		//接受
		public static final String PREPARE_PAYMENT="PREPARE_PAYMENT";		//准备付款
		public static final String PAID="PAID";		//已付款
		public static final String STRIKE_BALANCE="STRIKE_BALANCE";		//已冲账
		public static final String CLOSED="CLOSED";		//关闭
	}
	public final static class payWay{
		public static final String AUTOPAY = "AUTOPAY";		
		public static final String CASH = "CASH";		
		public static final String HKD_PAY = "HKD_PAY";
		public static final String HKD_PAY_CHINESE ="香港员工HKD付款";
	}
	public final static class payStatus{
		public static final String PAID="PAID";		//已付款
		public static final String UNPAID="UNPAID";		//未付款
	}
	public final static class refundStatus{
		public static final String REFUND="REFUND";		//已还款
		public static final String UNREFUND="UNREFUND";		//未还款
	}
	
	//备注类型
	public final static class remarkType {
		public static final String GRANT_APPROVAL = "GRANT_APPROVAL";	//授权审批
		public static final String GRANT_APPROVAL_CHINESE = "授权审批";	//授权审批
		public static final String OTHER = "OTHER";	//其他
		public static final String OTHER_CHINESE = "其他";	//其他
	}
	
	//报销单状态
	public final static class reimbursementStatus {
		public static final String PENDING="PENDING";		//草稿
		public static final String DEPT_APPROVE = "DEPT_APPROVE";		//用户部门批准
		public static final String FINANCIAL_DEPT_AUDIT = "FINANCIAL_DEPT_AUDIT";		//财务部门审核
		public static final String REJECT = "REJECT";		//拒绝
		public static final String ACCEPT = "ACCEPT";		//接受
		public static final String CLOSED = "CLOSED";		//已关闭
		public static final String PREPARE_PAYMENT="PREPARE_PAYMENT";		//准备付款
		public static final String PAID = "PAID";		//已付款
		public static final String STRIKE_BALANCE="STRIKE_BALANCE";		//已冲账
		
	}
	
	public final static class reimbursementType {
		
		//公务卡报销
		public static final String BUSINESS_CARD = "BUSINESS_CARD";
		//普通报销
		public static final String COMMON = "COMMON";
		//香港员工港币报销(HKD)
		public static final String HK_HKD = "HK_HKD";
		
	}
	/**
	 * 付款类型
	 * @author 
	 *
	 */
	public final static class paymentPayType{
		
		public static final String COMMON = "COMMON"; //普通付款
		public static final String OFFICIAL = "OFFICIAL"; //公务卡付款
		public static final String HK="HK";//香港员工付款
		
	}
	
	public final static class role {
		
		public static final String SYSTEM_ADMINISTRATOR = "系统管理员";
	}
	/**
	 * 借款单类型
	 * @author 
	 *
	 */
	public final static class borrowBillType{
		public static final String SPARE="SPARE"; //备用金借款
		public static final String COMMON="COMMON";	//普通借款
	}
	/**
	 * 单据备注类型
	 * @author 
	 *
	 */
	public final static class billRemarkType{
		public static final String GRANT_APPROVAL="GRANT_APPROVAL"; //授权审批
		public static final String OTHER="OTHER"; //其他
	}
	
	public final static class ActivitiTaskName{
		
	}
	public final static class relationship{
		public static final String GREATER="GREATER";
		public static final String EQUAL="EQUAL";
		public static final String LESS="LESS";
		
	}
	
	public final static class entry_type{
		public static final String FOR_FEE_COMPANY ="FOR_FEE_COMPANY ";
		public static final String FOR_PAY_COMPANY ="FOR_PAY_COMPANY ";
		public static final String COMMON="COMMON";
		
	}
	
	/**
	 * 员工工号前缀
	 * @author Admin
	 *
	 */
	public final static class employeeNoPrefix {
		
		public static final String HK="120";
	}
	
	/**
	 * 币种
	 * @author Admin
	 *
	 */
	public final static class currency {
		
		public static final String HKD="HKD";
		public static final String RMB="RMB";
	}
	
	public final static class entry {
		public static final Map<String, String> entryMap;
		static {
			entryMap = new HashMap<String, String>();
			entryMap.put("Company","company");
			entryMap.put("Account","account");
			entryMap.put("Cost Centre","costCentre");
			entryMap.put("Product/Service","productService");
			entryMap.put("Sales Channel","salesChannel");
			entryMap.put("Country","country");
			entryMap.put("Inter_Company","interCompany");
			entryMap.put("Project","project");
			entryMap.put("Spare","spare");
			entryMap.put("Debit","debit");
			entryMap.put("Credit","credit");
			entryMap.put("Converted Debit","convertedDebit");
			entryMap.put("Converted Credit","convertedCredit");
			entryMap.put("Description","description");
			entryMap.put("Line DEF Contex","lineDEFContex");
			entryMap.put("Line DEF 1","lineDEF1");
			entryMap.put("Rate","rate");
		}

	}
	
	public final static class glInterfaceFile {
		public static final Map<String, String> glMap;
		static {
			glMap = new HashMap<String, String>();
			glMap.put("STATUS","status");
			glMap.put("SET_OF_BOOKS_ID","setOfBooksId");
			glMap.put("ACCOUNTING_DATE","accountingDate");
			glMap.put("CURRENCY_CODE","currencyCode");
			glMap.put("DATE_CREATED","dateCreated");
			glMap.put("CREATED_BY","createdBy");
			glMap.put("ACTUAL_FLAG","actualFlag");
			glMap.put("USER_JE_CATEGORY_NAME","userJeCategoryName");
			glMap.put("USER_JE_SOURCE_NAME","userJeSourceName");
			glMap.put("CURRENCY_CONVERSION_DATE","currencyConversionDate");
			glMap.put("USER_CURRENCY_CONVERSION_TYPE","userCurrencyConversionType");
			glMap.put("CURRENCY_CONVERSION_RATE","currencyConversionRate");
			glMap.put("ENTERED_DR","enteredDr");
			glMap.put("ENTERED_CR","enteredCr");
			glMap.put("ACCOUNTED_DR","accountedDr");
			glMap.put("ACCOUNTED_CR","accountedCr");
			glMap.put("REFERENCE1","reference1");
			glMap.put("REFERENCE2","reference2");
			glMap.put("REFERENCE4","reference4");
			glMap.put("REFERENCE5","reference5");
			glMap.put("REFERENCE6","reference6");
			glMap.put("REFERENCE7","reference7");
			glMap.put("REFERENCE8","reference8");
			glMap.put("REFERENCE10","reference10");
			glMap.put("SEGMENT1 (PK)","segment1");
			glMap.put("SEGMENT2 (PK)","segment2");
			glMap.put("SEGMENT3 (PK)","segment3");
			glMap.put("SEGMENT4 (PK)","segment4");
			glMap.put("SEGMENT5 (PK)","segment5");
			glMap.put("SEGMENT6 (PK)","segment6");
			glMap.put("SEGMENT7 (PK)","segment7");
			glMap.put("SEGMENT8 (PK)","segment8");
			glMap.put("SEGMENT9 (PK)","segment9");
			glMap.put("PERIOD_NAME","periodName");
			glMap.put("BUDGET_VERSION_ID","budgetVersionId");
			glMap.put("ATTRIBUTE1","attribute1");
			glMap.put("ATTRIBUTE2","attribute2");
			glMap.put("ATTRIBUTE3","attribute3");
			glMap.put("ATTRIBUTE4","attribute4");
			glMap.put("ATTRIBUTE5","attribute5");
			glMap.put("ATTRIBUTE6","attribute6");
			glMap.put("ATTRIBUTE7","attribute7");
			glMap.put("ATTRIBUTE8","attribute8");
			glMap.put("ATTRIBUTE9","attribute9");
			glMap.put("ATTRIBUTE10","attribute10");
			glMap.put("CONTEXT","context");
			
		}
		

	}
	public final static class orderBy {
		public static final Map<String, String> entryMapOrder;
		public static final Map<String, String> glMapOrder;
		static {
			
			//gl 字段排序
			glMapOrder = new HashMap<String, String>();
			glMapOrder.put("STATUS","0");
			glMapOrder.put("SET_OF_BOOKS_ID","1");
			glMapOrder.put("ACCOUNTING_DATE","2");
			glMapOrder.put("CURRENCY_CODE","3");
			glMapOrder.put("DATE_CREATED","4");
			glMapOrder.put("CREATED_BY","5");
			glMapOrder.put("ACTUAL_FLAG","6");
			glMapOrder.put("USER_JE_CATEGORY_NAME","7");
			glMapOrder.put("USER_JE_SOURCE_NAME","8");
			glMapOrder.put("CURRENCY_CONVERSION_DATE","9");
			glMapOrder.put("USER_CURRENCY_CONVERSION_TYPE","10");
			glMapOrder.put("CURRENCY_CONVERSION_RATE","11");
			glMapOrder.put("ENTERED_DR","12");
			glMapOrder.put("ENTERED_CR","13");
			glMapOrder.put("ACCOUNTED_DR","14");
			glMapOrder.put("ACCOUNTED_CR","15");
			glMapOrder.put("REFERENCE1","16");
			glMapOrder.put("REFERENCE2","17");
			glMapOrder.put("REFERENCE4","18");
			glMapOrder.put("REFERENCE5","19");
			glMapOrder.put("REFERENCE6","20");
			glMapOrder.put("REFERENCE7","21");
			glMapOrder.put("REFERENCE8","22");
			glMapOrder.put("REFERENCE10","23");
			glMapOrder.put("SEGMENT1 (PK)","24");
			glMapOrder.put("SEGMENT2 (PK)","25");
			glMapOrder.put("SEGMENT3 (PK)","26");
			glMapOrder.put("SEGMENT4 (PK)","27");
			glMapOrder.put("SEGMENT5 (PK)","28");
			glMapOrder.put("SEGMENT6 (PK)","29");
			glMapOrder.put("SEGMENT7 (PK)","30");
			glMapOrder.put("SEGMENT8 (PK)","31");
			glMapOrder.put("SEGMENT9 (PK)","32");
			glMapOrder.put("PERIOD_NAME","33");
			glMapOrder.put("BUDGET_VERSION_ID","34");
			glMapOrder.put("ATTRIBUTE1","35");
			glMapOrder.put("ATTRIBUTE2","36");
			glMapOrder.put("ATTRIBUTE3","37");
			glMapOrder.put("ATTRIBUTE4","38");
			glMapOrder.put("ATTRIBUTE5","39");
			glMapOrder.put("ATTRIBUTE6","40");
			glMapOrder.put("ATTRIBUTE7","41");
			glMapOrder.put("ATTRIBUTE8","42");
			glMapOrder.put("ATTRIBUTE9","43");
			glMapOrder.put("ATTRIBUTE10","44");
			glMapOrder.put("CONTEXT","45");
			
			entryMapOrder = new HashMap<String, String>();
			entryMapOrder.put("Company","0");
			entryMapOrder.put("Account","1");
			entryMapOrder.put("Cost Centre","2");
			entryMapOrder.put("Product/Service","3");
			entryMapOrder.put("Sales Channel","4");
			entryMapOrder.put("Country","5");
			entryMapOrder.put("Inter_Company","6");
			entryMapOrder.put("Project","7");
			entryMapOrder.put("Spare","8");
			entryMapOrder.put("Debit","9");
			entryMapOrder.put("Credit","10");
			entryMapOrder.put("Converted Debit","11");
			entryMapOrder.put("Converted Credit","12");
			entryMapOrder.put("Description","13");
			entryMapOrder.put("Line DEF Contex","14");
			entryMapOrder.put("Line DEF 1","15");
			entryMapOrder.put("Rate","16");
			
		}
		
		
	}
	public final static class auditStatus{
		
		public static final String UNAUDIT = "UNAUDIT"; //未审
		public static final String AUDITED = "AUDITED"; //已审
		public static final String NOTSURE = "NOTSURE"; //未确认
		public static final String SURE = "SURE"; //已确认
		
	}
	
	public final static class fileSave {
		
		public final static  String PARA1_BORROWING = "BORROWING";
		public final static  String PARA1_REIMBURSEMENT = "REIMBURSEMENT";
		public final static  String PARA1_BORROWING_REMARK = "BORROWING_REMARK";
		public final static  String PARA1_REIMBURSEMENT_REMARK = "REIMBURSEMENT_REMARK";
	}
	
	public final static class mailStaticInfo {
		public final static String greetings = "尊敬的用户：";
		public final static String sayHi = "您好!";
	    public final static String remind = "请勿直接回复此邮件，如有系统问题，请联络资讯服务部服务热线#8571";
	    public final static String thanks = "谢谢！";
	    public final static String inscribePeo = "员工报销及借款系统管理员";
	    public final static String inscribeOrg = "盐田国际资讯服务部";
	    
	    public final static String e_scanReimInfo = "jsp/common/ReimTab.jsp";
	    public final static String e_deptApproval = "jsp/reimbursement/reimburseApproval.jsp";
	    public final static String e_deptApprovalInfo = "jsp/reimbursement/reimDepartApprTab.jsp";
	    public final static String e_cashierApproval = "jsp/reimbursement/cashierVerifyReimbursement.jsp";
	    public final static String e_cashierApprovalInfo = "jsp/reimbursement/cashierApprovalInput.jsp";
	    public final static String e_treasurerApproval = "jsp/reimbursement/treasurerVerifyReimbursement.jsp";
	    public final static String e_treasurerApprovalInfo = "jsp/reimbursement/treasureApprovalInput.jsp";
	    
	    public final static String o_scanBorrowInfo = "jsp/borrowing/borrowingInput.jsp";
	    public final static String o_approvalInfo = "jsp/borrowing/auditInput.jsp";
	    public final static String o_deptApproval = "jsp/borrowing/borrowApproval.jsp";
	    public final static String o_cashierApproval = "jsp/borrowing/cashierVerifyBorrowing.jsp";
	    public final static String o_treasurerApproval = "jsp/borrowing/treasurerVerifyBorrowing.jsp";
	    
	}
	
	/**
	 * 没有在数据库中配置的菜单映射
	 */
	public static final class menuItem {
		public static final Map<String, String> mapItem;
		static {
			mapItem = new HashMap<String, String>();
			
			mapItem.put("/jsp/common/ReimTab.jsp", "报销单-查看");
			mapItem.put("/jsp/reimbursement/reimDepartApprTab.jsp", "报销单-部门审批");
			mapItem.put("/jsp/reimbursement/cashierApprovalInput.jsp", "报销单-部门审批");
			mapItem.put("/jsp/reimbursement/treasureApprovalInput.jsp", "报销单-主管审批");
			
			mapItem.put("/jsp/borrowing/borrowingInput.jsp", "借款-修改申请单");
		}
	}
	
	
}
