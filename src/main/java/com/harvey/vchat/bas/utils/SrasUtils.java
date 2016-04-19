package com.harvey.vchat.bas.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.harvey.vchat.bas.entity.MessageEntity;
import com.harvey.vchat.common.Constants;
import com.harvey.vchat.utils.DateHelper;

public class SrasUtils {
	
	/**
	 * 
	 * @param paymentPayType 付款类型
	 * @param billNoOrChequeNo 支票号或者报销单号
	 * @param isClear 是否是报销冲销  
	 * @return
	 */
	public static String getEntryFileName(String paymentPayType,String billNoOrChequeNo,String isClear){
		String fileName="";
		if(isClear.equals(Constants.status.Y)){
			fileName+="Clear"+billNoOrChequeNo;
		}else {
			if(paymentPayType.equals(Constants.paymentPayType.COMMON)){
				fileName+="Entry"+billNoOrChequeNo;
			}else if(paymentPayType.equals(Constants.paymentPayType.HK)){
				fileName+="Entryhk"+billNoOrChequeNo;
			}else if(paymentPayType.equals(Constants.paymentPayType.OFFICIAL)){
				fileName+="Entrygwk"+billNoOrChequeNo;
			}
		}
		return fileName;
	}
	/**
	 * 
	 * @param fileGenerationDate 文件生成时间
	 * @param code 公司代码
	 * @param isPayCompany 是否为付款公司
	 * @return
	 */
	public static String getGlFileName(Date fileGenerationDate,String code,String isPayCompany){
		String fileName="";
//		2xxx_GL_INTERFACE_SRAS_DDMMYYYYHHMISS.csv
//		EOF_2xxx_GL_INTERFACE_SRAS_ DDMMYYYYHHMISS.csv
		if(isPayCompany.equals(Constants.status.Y)){
			fileName+=code+"_GL_INTERFACE_SRAS_"+DateHelper.dateToString(fileGenerationDate, "ddMMYYYYHHmmss");
//		2XXX_GL_DDMMYYYYHHMISS.csv
		}else {
			fileName+="EOF_"+code+"_GL_INTERFACE_SRAS_"+DateHelper.dateToString(fileGenerationDate, "ddMMYYYYHHmmss");
//		EOF_2XXX_GL_DDMMYYYYHHMISS
		}
		return fileName;
	}
	public static MessageEntity isNullUserSession(){
		MessageEntity messageEntity =new MessageEntity();
		messageEntity.setError(true);
		messageEntity.setMessage("回话超期，请登录后再试！");
		return messageEntity;
	}
	
	public static String decode(String str){
		String result="";
		if(StringUtils.isBlank(str)){
			return result;
		}else{
			try {
				result=java.net.URLDecoder.decode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 判断是否为空 if null || "" return true else false;
	 * 
	 * @return
	 */
	public static boolean isEmpty(String obj) {
		if (obj == null || "".equals(obj) || "undefined".equals(obj)
				|| "null".equals(obj)) {
			return true;
		} else {
			return false;
		}
	}
	
	//补零
	public static String getNewString(String value,String repValue,int dig){
		String newValue=repValue+value;
    	String result=newValue.substring(newValue.length()-dig,newValue.length()); 
    	return result;
	}
}
