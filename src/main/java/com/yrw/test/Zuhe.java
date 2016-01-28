package com.yrw.test;
import java.util.Scanner;

//题目：现有ABCDE 5个球 构成的排列组合 可重复抽取 最多取到16个 共有多少种组合方式？
//
//比如：取1个球可以构成的组合有 A B C D E 共5种，取2个球可以构成的组合有  5+4+3+2+1=15种 （BA 和 AB 这种重复的排列 算成一种）
//
//　　AA AB AC AD AE
//
//　　BB BC BD BE
//
//　　CC CD CE
//
//　　DD DE
//
//　　EE
//
//取 3 个球可以构成的组合是 （5+4+3+2+1）+（4+3+2+1）+（3+2+1）+（2+1）+1= 35种
//
//　　AAA AAB AAC AAD AAE
//
//　　ABB ABC ABD ABE
//
//　　ACC ACD ACE
//
//　　ADD ADE
//
//　　AEE
//
//　　BBB BBC BBD BBE
//
//　　BCC BCD BCE
//
//　　BDD BDE
//
//　　BEE
//
//　　CCC CCD CCE
//
//　　CDD CDE
//
//　　CEE
//
//　　DDD DDE
//　　DEE
//　　EEE

 
 /**
  * 主要是利用递归来来实现。主要思想是把一个字符串分为俩段来处理，首先取出第一个字符串，然后用后面的字符来与它进行拼凑。
  */
 public class Zuhe {
     private static String str = "ABCDE";// 字符串
     private static int n = 3;// 选择的个数
     private static int count = 0;//组合的个数
 
     public static void main(String[] args) {
         new Zuhe();
     }
 
     public Zuhe() {
         Scanner input = new Scanner(System.in);
         System.out.println("请输入要选择的个数（要少于" + str.length() + "个）");
         n = Integer.parseInt(input.nextLine());
         find("", 0);
         System.out.println("共有"+count+"种组合");
 
     }
     /**
      *第一个参数是代表第一个字符，第二个参数代表开始寻找点的位置
      */
     public static void find(String s, int i) {
         // 保存上一次的字符串
         String temp = s;
         //判断是否符合要求
         if (s.length() == n) {
             count++;
 
             System.out.print(s + " ");
             if (count % 10 == 0)
                 System.out.println();
             return;
         }
         //从寻找点开始循环，风之境地
         for (int k =i; k < str.length(); k++) {
             s = temp;
             s += str.charAt(k);
             find(s, k);
         }     
     }
 }