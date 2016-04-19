package com.harvey.vchat.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateHelper {
	
//	private static Calendar cale = Calendar.getInstance();

	public static String getYearToString(int digit){
		if(digit>4 || digit<1){
			digit=4;
		}
		Calendar cale = Calendar.getInstance();
		String year = "0000"+cale.get(Calendar.YEAR) + "";
        year = year.substring(year.length() - digit);
		return year;
	}
	
	public static String getMonthToString(){
		Calendar cale = Calendar.getInstance();
		int m = cale.get(Calendar.MONTH) + 1;
        String month = "00" + m;
        month = month.substring(month.length() - 2);
		return month;
	}
	
	public static String getDateToString(){
		Calendar cale = Calendar.getInstance();
		int d = cale.get(Calendar.DATE);
		String date = "00" + d;
		date = date.substring(date.length() - 2);
		return date;
	}
	public static String dateToString(Date time ,String formate, Locale lang){ 
		if(time==null){
			return "";
		}
		SimpleDateFormat formatter; 
		formatter = new SimpleDateFormat (formate,lang); 
		String ctime = formatter.format(time); 
		return ctime; 
	}
	public static String dateToString(Date time ,String formate){ 
		if(time==null){
			return "";
		}
	    SimpleDateFormat formatter; 
	    formatter = new SimpleDateFormat (formate); 
	    String ctime = formatter.format(time); 
	    return ctime; 
	}
	@SuppressWarnings("deprecation")
	public static Date getStartDateTime(Date date){
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		return date;
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date getEndDateTime(Date date){
		date.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
		return date;
	}
	
	public static Date StrToDate(String str,String dateFormate) {
		  
		SimpleDateFormat format = new SimpleDateFormat(dateFormate);
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static String DateStrEnToNum(String str) {
		String reg = "(\\d+)-([a-zA-Z]+)-(\\d+)";
	     String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	     String d1 = str;
	     String m = d1.replaceAll(reg, "$2");
	     int index = -1;
	     for(int i = 0; i < months.length; i++)
	     {
	         if(m.equals(months[i]))
	         {
	             index = i + 1;
	             break;
	         }
	     }
	     String d2 = d1.replaceAll(reg, "$1-"+index+"-$3");
		
		return d2;
	}
	   
	public static void main(String[] args) {
		 
		System.out.println(DateHelper.getDateToString());
		
	}
	public static Date getDateBefore(Date d, int day) {      
        Calendar now = Calendar.getInstance();      
        now.setTime(d);      
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);      
        return now.getTime();      
    }     
      
    public static Date getDateAfter(Date d, int day) {      
       Calendar now = Calendar.getInstance();      
        now.setTime(d);      
       now.set(Calendar.DATE, now.get(Calendar.DATE) + day);      
       return now.getTime();      
    } 
}
