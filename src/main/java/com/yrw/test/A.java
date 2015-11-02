package com.yrw.test;

/**
 * 内部类生命对象形式
 * @author yrw
 *
 */
public class A {

	public int getNumber(int a){
		return a+1;
	}
	
	public class B extends A {
		public int getNumber(int a){
			return a+2;
		}
	}
	
	public static void main(String[] args) {
		B a = new A().new B();					//创建成员内部类对象的一般形式为：  外部类类名.内部类类名 xxx = 外部类对象名.new 内部类类名()
		System.out.println(a.getNumber(0));

	}

}


