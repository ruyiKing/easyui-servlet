package com.yrw.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Readtxt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream iStream = Readtxt.class.getResourceAsStream("C:/Users/fate/Desktop/info.txt");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(iStream));
		String line = "";
		try {
			while ((line=bufferedReader.readLine())!=null){
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
