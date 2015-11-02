package com.yrw.test.interview;
/**
 * 
 * @Url:http://www.cnblogs.com/DreamSea/archive/2011/11/20/2256396.html
 * 
 * 编译后的代码
 * Integer i1 = Integer.valueOf(400);
    Integer i2 = Integer.valueOf(400);
    Integer i3 = Integer.valueOf(0);
    Integer i4 = new Integer(400);
    Integer i5 = new Integer(400);
    Integer i6 = new Integer(0);
    
    System.out.println("i1=i2\t" + (i1 == i2));
    System.out.println("i1=i2+i3\t" + (i1.intValue() == i2.intValue() + i3.intValue()));
    System.out.println("i4=i5\t" + (i4 == i5));
    System.out.println("i4=i5+i6\t" + (i4.intValue() == i5.intValue() + i6.intValue()));
 * 
 * @author fate
 *
 */
public class IntegerTest {
    public static void main(String[] args) {    
        objPoolTest();
    }

    public static void objPoolTest() {
        /*Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        */
        Integer i1 = 400;
        Integer i2 = 400;
        Integer i3 = 0;
        Integer i4 = new Integer(400);
        Integer i5 = new Integer(400);
        Integer i6 = new Integer(0);
        
        System.out.println("i1=i2\t" + (i1 == i2));
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));
        System.out.println("i4=i5\t" + (i4 == i5));
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));    
        
        System.out.println();        
    }
}