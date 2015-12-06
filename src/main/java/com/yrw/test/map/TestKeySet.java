package com.yrw.test.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TestKeySet {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("1","one");
		map.put("2", "two");
		map.put("3", "third");
		map.put("4", "four");
		
		Set<String> key1=map.keySet();
		Set<String> key2=map.keySet();
		Set<String> key3=map.keySet();
		System.out.println(key1);
		System.out.println(key1==key2);
		System.out.println(key1==key3);
		
		
	}

}
