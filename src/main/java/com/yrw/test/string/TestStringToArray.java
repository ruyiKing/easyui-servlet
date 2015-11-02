package com.yrw.test.string;

import java.util.Arrays;

public class TestStringToArray {

	public static void main(String[] args) {
		String s="092734239572398923asdfo'l;kb;[pertertqweerdfs";
		char[] cs=s.toCharArray();  
		cs.toString();
		Arrays.sort(cs);
		String news = String.valueOf(cs);
		System.out.println(news);
		
	}
}
