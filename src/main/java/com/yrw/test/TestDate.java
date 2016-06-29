package com.yrw.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	
	public static void main(String[] args) throws ParseException {
		/*String sdate = "2015-11-4";
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dFormat.parse(sdate);
		System.out.println(date);*/
		
		String	str0 = "2015年07月05日";
		Date d1 = new SimpleDateFormat("yyyy年MM月dd日").parse(str0);//定义起始日期
		SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
		SimpleDateFormat sdf2= new SimpleDateFormat("dd");
		String str1 = sdf0.format(d1);
		String str2 = sdf1.format(d1);
		String str3 = sdf2.format(d1);
		System.out.println("年份为："+str1);
		System.out.println("月份为："+str2);
		System.out.println("日为："+str3);
		String dString = new SimpleDateFormat("yyMMddhhmmssS").format(new Date());
		System.out.println(dString);
	}

}
