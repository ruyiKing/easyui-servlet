package com.yrw.test;
import java.io.*;
class BufferedReaderDemo{
  public static void main(String[] args)throws IOException { 
    BufferedReader bufferedReader =new BufferedReader(
        new InputStreamReader(System.in));
 
    System.out.print("请输入一系列文字，可包括空格："); 
    String text =bufferedReader.readLine(); 
    System.out.println("请输入文字："+text);
  } 
}