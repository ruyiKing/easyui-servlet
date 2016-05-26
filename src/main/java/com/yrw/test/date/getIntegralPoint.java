package com.yrw.test.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class getIntegralPoint {

	public static void main(String[] args) {
		
		/**	方法一*/
//		Date date = new Date();
//		String sIntergralPoint="";
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println("当前时间："+df.format(date));
//		Calendar.getInstance();
//		Integer secondInt = Calendar.MINUTE;
//		if(secondInt<30){
//			sIntergralPoint=df.format(date).substring(0, 14)+"00:00";
//		}else{
//			sIntergralPoint=df.format(date).substring(0, 14)+"30:00";
//		}
//		System.out.println("获取整数时间为："+sIntergralPoint);
		
		/**	方法二*/
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int mm = cal.get(Calendar.MINUTE);
		String endTime="";
		Date d2= new Date();
		if(mm < 30){
			endTime = simpleDateFormat(d2, "yyyy-MM-dd HH:00:00");
		}else{
			endTime = simpleDateFormat(d2, "yyyy-MM-dd HH:30:00");
		}
		System.out.println("以半小时为单位去整数时间："+endTime);
	}

	static String simpleDateFormat(Date date,String str){
		SimpleDateFormat sFormat=new SimpleDateFormat(str);
		return sFormat.format(date);
	}
}
