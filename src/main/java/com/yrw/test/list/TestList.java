package com.yrw.test.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Java中ArrayList和LinkedList区别
 * @author fate
 * 一般大家都知道ArrayList和LinkedList的大致区别： 
     1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。 
     2.对于随机访问get和set，ArrayList绝对优于LinkedList，因为LinkedList要移动指针。
     3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。 

 *{@link http://www.cnblogs.com/mimimimimi/p/4090401.html} 
 */
public class TestList{   
     public static final int N=50000;   
  
     public static List<Integer> values;   
  
     static{   
         Integer vals[]=new Integer[N];   
  
         Random r=new Random();   
  
         for(int i=0,currval=0;i<N;i++){   
             vals[i]=new Integer(currval);   
             currval+=r.nextInt(100)+1;   
         }   
  
         values=Arrays.asList(vals);   
     }   
  
     static long timeList(List<Integer> lst){   
         long start=System.currentTimeMillis();   
         for(int i=0;i<N;i++){   
             int index=Collections.binarySearch(lst, values.get(i));   
             if(index!=i)   
                 System.out.println("***错误***");
         }
         return System.currentTimeMillis()-start;   
     }   
     public static void main(String args[]){   
         System.out.println("ArrayList消耗时间："+timeList(new ArrayList<Integer>(values)));   
         System.out.println("LinkedList消耗时间："+timeList(new LinkedList<Integer>(values)));   
     }   
}   