package com.yrw.test.string;

import java.util.Arrays;
import java.util.List;

public class TestStr {

	public static void main(String[] args) {
		/*String str = "{value=1,2,3,4}";
		str = str.substring(7, str.length()-1);
		String[] arr = str.split(",");
		List<String> l = Arrays.asList(arr);
		Integer.parseInt(l.get(0));*/
		
		String sourceStr="2015313213213.png";
		String[] sourceStrArray = sourceStr.split("\\.");
        for (int i = 0; i < sourceStrArray.length; i++) {
            System.out.println(sourceStrArray[0]);
        }
		

	}

}
