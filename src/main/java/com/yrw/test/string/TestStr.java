package com.yrw.test.string;

import java.util.Arrays;
import java.util.List;

public class TestStr {

	public static void main(String[] args) {
		String str = "{value=1,2,3,4}";
		str = str.substring(7, str.length()-1);
		String[] arr = str.split(",");
		List<String> l = Arrays.asList(arr);
		Integer.parseInt(l.get(0));

	}

}
