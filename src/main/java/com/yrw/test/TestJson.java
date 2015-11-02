package com.yrw.test;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

public class TestJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("2", "原因2");
		map.put("3", "原因3");
		
		JSONArray array = JSONArray.fromObject(map);
		String jsonstr = array.toString();
		System.out.println(jsonstr);

	}

}
