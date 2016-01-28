package com.yrw.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import net.sf.json.JSONArray;

public class TestJson {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
//		Map<String, String> map = new HashMap<>();
//		map.put("2", "原因2");
//		map.put("3", "原因3");
//		
//		JSONArray array = JSONArray.fromObject(map);
//		String jsonstr = array.toString();
//		System.out.println(jsonstr);

		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		System.out.println(df.parse("2014-08-23T09:20:05Z").toString());
		
		System.out.println(df.format(df.parse("2014-08-23T09:20:05Z")));
		
	}

}
