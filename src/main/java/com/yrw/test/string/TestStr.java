package com.yrw.test.string;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStr {

	public static void main(String[] args) {
		/*String str = "{value=1,2,3,4}";
		str = str.substring(7, str.length()-1);
		String[] arr = str.split(",");
		List<String> l = Arrays.asList(arr);
		Integer.parseInt(l.get(0));*/
	
//		String sourceStr="2015313213213.png";
//		String[] sourceStrArray = sourceStr.split("\\.");
//        for (int i = 0; i < sourceStrArray.length; i++) {
//            System.out.println(sourceStrArray[0]);
//        }
//		
		Pattern r = Pattern.compile("^(\\-)?\\d+(\\.\\d{1,2})?$");
        String d= "-3.145";
        String dd = "2016-05";
        Matcher m = r.matcher(d);
//        System.out.println(d.matches("^(\\-)?\\d+(\\.\\d{1,2})?"));
//        System.out.println(dd.matches("\\d{4}-(0[1-9]|1[0-2])"));
        
        System.out.println(Double.parseDouble(d));
	}

}
