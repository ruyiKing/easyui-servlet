package com.yrw.test;
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.LinkedList;  
import java.util.List;  
  
/**
 * 
 * 当需要插入数据的时候，如果是在集合的前段（大概集合容量的前1/10）处插入数据时，LinkedList性能明显优于ArrayList，
 * 但是！！！！当在集合的中部甚至靠后的位置插入大量数据时，ArrayList的性能反而远远优于LinkedList，
 * 所以，LinkedList相较于ArrayList的唯一优势在于集合前段的数据的插入。
 * 
 * @author fate
 *
 */
public class ArrayOrLinked {  
    static List<Integer> array=new ArrayList<Integer>();  
    static List<Integer> linked=new LinkedList<Integer>();  
  
    public static void main(String[] args) {  
  
  
        for(int i=0;i<10000;i++){  
            array.add(i);  
            linked.add(i);  
        }  
        System.out.println("array time:"+getTime(array));  
        System.out.println("linked time:"+getTime(linked));  
        System.out.println("array add time:"+addTime(array));  
        System.out.println("linked add time:"+addTime(linked));  
  
    }  
    public static long getTime(List<Integer> list){  
        long time=System.currentTimeMillis();  
        for(int i=0;i<10000;i++){  
            int index=Collections.binarySearch(list, list.get(i));  
            if(index!=i){  
                System.out.println("ERROR!");  
            }  
        }  
        return System.currentTimeMillis()-time;  
    }  
    public static long addTime(List<Integer> list){  
        long time=System.currentTimeMillis();  
        for(int i=1;i<10000;i++){  
            list.add(5000,i);  //5000改成0 LinkList效率提高   
        }  
        return System.currentTimeMillis()-time;  
          
    }  
  
}  