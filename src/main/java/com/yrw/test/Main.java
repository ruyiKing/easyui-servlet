package com.yrw.test;

public class Main {

	public static void main(String[] args) {
		System.out.println(MainPerson.name);
		System.out.println(MainPerson.age);

	}
}

class MainPerson {
	public static String name = "张三";
	static int age = 21;
}
