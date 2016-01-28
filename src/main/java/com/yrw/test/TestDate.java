package com.yrw.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	
	public static void main(String[] args) throws ParseException {
		String sdate = "2015-11-4";
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dFormat.parse(sdate);
		System.out.println(date);
	}

}
