package com.harvey.vchat.bas.utils;

public class StringUtils {
	
	public static boolean isNotBlank(String str){
		if (str != null && str.trim().length() > 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isBlank(String str){
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}

}
