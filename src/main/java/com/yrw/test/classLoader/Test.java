package com.yrw.test.classLoader;
public class Test
{
	/**
	 * 类加载顺序：静态变量、与静态块进行加载（静态成员变量和静态初始化块级别相同，非静态成员变量和非静态初始化块级别相同）
	 * new一个实体类加载顺序（有父类）：1、父类的静态代码；2、子类的静态代码；3、父类的非静态代码；4、父类的构造方法；5、子类的非静态代码；6、子类的构造方法；（代码指：块或成员变量）
	 */
   
    public static void main(String[] args)
    {
    	
          Parent.parentStaticMethod();    //step1
//          Parent.parentStaticMethod2();   //step2
//          Child child = new Child();		//step3
        
    }

}