package com.yrw.test.classLoader;
public class Parent
{
    public static int t = parentStaticMethod2();
    public int t1 = parentMethod();
    
    static
    {
        System.out.println("父类静态初始化块");
    }
    public Parent()
    {
        System.out.println("父类构造方法");
    }
    {
        System.out.println("父类非静态初始化块");
    }
    public static int parentStaticMethod()
    {
        System.out.println("父类静态方法");
        return 10;
    }
    public static int parentStaticMethod2()
    {
        System.out.println("父类静态方法2");
        return 9;
    }
    public int parentMethod(){
    	System.out.println("父类非静态方法");
    	return 2;
    }
  
    @Override
    protected void finalize() throws Throwable
    {
        // TODO Auto-generated method stub
        super.finalize();
        System.out.println("销毁父类");
    }
    
}