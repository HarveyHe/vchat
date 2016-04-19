package com.harvey.vchat.bas.utils;

import com.harvey.common.core.context.Context;
import com.harvey.vchat.bas.model.BasSerialNumberModel;
import com.harvey.vchat.bas.service.BasSerialNumberService;
import com.harvey.vchat.common.Constants;
import com.harvey.vchat.utils.DateHelper;

public class SequenceNoList {
	
	BasSerialNumberService basSerialNumberService;
	
	/**
	 *  生成报销借款编号
	 * 报销单、借款单编号规则：付款公司编号代码＋单据类型（1位字母）+费用公司编号编码(2位)＋提交申请年份（2位数字）＋提交申请月份（2位数字）＋流水号（4位数字）。
	 * 单据类型分别为：报销（E），借款（O），如付款公司与费用公司相同，则不显示费用公司代码；各公司的编码来自公司维护；
	 * @param payCompanyCode	付款公司编号代码
	 * @param billType	单据类型，只能为E或O
	 * @param feeCompanyCode	费用公司编号编码
	 * @return
	 */
	public static String getEOSequenceNo(String payCompanyCode,String billType,String feeCompanyCode) {
		String sequenceNo = "";
		//付款公司代码
		if (StringUtils.isBlank(payCompanyCode)) {
			throw new RuntimeException("生成报销借款编号:付款公司编号代码不能为空");
		}
		sequenceNo += payCompanyCode;
		//单据类型
		if(StringUtils.isBlank(billType) || (!Constants.billType.BORROW.equals(billType) && 
				!Constants.billType.REIMBURSEMENT.equals(billType))) {
			throw new RuntimeException("生成报销借款编号:单据类型不匹配");
		}
		sequenceNo += billType;
		
		//费用公司代码
		if (StringUtils.isNotBlank(feeCompanyCode) && feeCompanyCode.length() != 2) {
			throw new RuntimeException("生成报销借款编号:费用公司编号编码长度不为2");
		}
		if(feeCompanyCode == null) {
			feeCompanyCode = "";
		}
		
		sequenceNo += feeCompanyCode;
		//年份
		sequenceNo += DateHelper.getYearToString(2);
		//月份
		sequenceNo += DateHelper.getMonthToString();
		//流水号
		sequenceNo += getBillSerialNo(billType,4);
		
		return sequenceNo;
	}
	/**
	 *  生成报销借款编号
	 * 报销单、借款单编号规则：付款公司编号代码＋单据类型（1位字母）+费用公司编号编码(2位)＋提交申请年份（2位数字）＋提交申请月份（2位数字）＋流水号（4位数字）。
	 * 单据类型分别为：报销（E），借款（O），如付款公司与费用公司相同，则不显示费用公司代码；各公司的编码来自公司维护；
	 * @param payCompanyCode	付款公司编号代码
	 * @param billType	单据类型，只能为E或O
	 * @param feeCompanyCode	费用公司编号编码
	 * @param companyCode	付款公司代码
	 * @return
	 */
	public static String getEOSequenceNo(String payCompanyCode,String billType,String feeCompanyCode,String companyCode) {
		String sequenceNo = "";
		//付款公司代码
		if (StringUtils.isBlank(payCompanyCode)) {
			throw new RuntimeException("生成报销借款编号:付款公司编号代码不能为空");
		}
		sequenceNo += payCompanyCode;
		//单据类型
		if(StringUtils.isBlank(billType) || (!Constants.billType.BORROW.equals(billType) && 
				!Constants.billType.REIMBURSEMENT.equals(billType))) {
			throw new RuntimeException("生成报销借款编号:单据类型不匹配");
		}
		sequenceNo += billType;
		
		//费用公司代码
		if (StringUtils.isNotBlank(feeCompanyCode) && feeCompanyCode.length() != 2) {
			throw new RuntimeException("生成报销借款编号:费用公司编号编码长度不为2");
		}
		if(feeCompanyCode == null) {
			feeCompanyCode = "";
		}
		
		sequenceNo += feeCompanyCode;
		//年份
		sequenceNo += DateHelper.getYearToString(2);
		//月份
		sequenceNo += DateHelper.getMonthToString();
		//流水号
		sequenceNo += getBillSerialNo(billType,4,companyCode);
		
		return sequenceNo;
	}
	
	public static String getBillSerialNo(String billType,int digit){
		BasSerialNumberService basSerialNumberService=Context.getBean(BasSerialNumberService.class);
		BasSerialNumberModel basSerialNumberModel = basSerialNumberService.getBillSerialNumber(billType);
		if(basSerialNumberModel == null){
			basSerialNumberModel = new BasSerialNumberModel();
			basSerialNumberModel.setType(billType);
			basSerialNumberModel.setSerialNo("0000");
			basSerialNumberService.save(basSerialNumberModel);
		}
		int temp = Integer.parseInt(basSerialNumberModel.getSerialNo()) + 1;
		String serialNo = "000000" + temp;
		serialNo = serialNo.substring(serialNo.length() - digit); // 流水号
		basSerialNumberModel.setSerialNo(serialNo);
		basSerialNumberService.save(basSerialNumberModel);
		return serialNo;
	}
	public static String getBillSerialNo(String billType,int digit,String companyCode){
		BasSerialNumberService basSerialNumberService=Context.getBean(BasSerialNumberService.class);
		BasSerialNumberModel basSerialNumberModel = basSerialNumberService.getBillSerialNumber(billType,companyCode);
		int temp = Integer.parseInt(basSerialNumberModel.getSerialNo()) + 1;
		String serialNo = "000000" + temp;
		serialNo = serialNo.substring(serialNo.length() - digit); // 流水号
		basSerialNumberModel.setSerialNo(serialNo);
		basSerialNumberService.save(basSerialNumberModel);
		return serialNo;
	}
	/**
	 * “AP”＋当前系统日期年份（2位数字）＋当前系统日期月份（2位数字）＋当前系统日期日子（2位数字）＋流水号（3位数字）
	 * @return
	 */
	public static String getBanchNo(){
		String banchNo="AP";
		//年份
//		String currentYearMonthDay = getCurrentYearMonthDay();
		banchNo += DateHelper.getYearToString(2);
		//月份
		banchNo += DateHelper.getMonthToString();
		banchNo += DateHelper.getDateToString();
		//流水号
		banchNo += getBillSerialNo("BANCH_NO",3);
		return banchNo;
	}
	public static String getHKChequeNo(){
		String hkCheque="HK";
		//年份
		hkCheque += DateHelper.getYearToString(2);
		//月份
		hkCheque += DateHelper.getMonthToString();
		hkCheque += DateHelper.getDateToString();
		//流水号
		hkCheque += "-"+getBillSerialNo("HKD_NO",4);
		return hkCheque;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			System.out.println(getEOSequenceNo("AE", "E", "EA"));
		}
	}
	
	

}
