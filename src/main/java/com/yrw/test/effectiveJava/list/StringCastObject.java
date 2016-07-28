package com.yrw.test.effectiveJava.list;

import java.util.ArrayList;
import java.util.List;

public class StringCastObject {
	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		a.add("astring");
		a.add("bstring");
		List<Object> b = convert(a, Object.class);
		//convert()等同于下列方法。
//		List<?> c = a;
//		List<Object> d = (List<Object>)c;
		System.out.println(b);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> convert(List<?> list, Class<T> c) {
		return (List<T>)list;
	}

}
