package com.yrw.test.redis;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
public class RedisKeyJava {
   private static Jedis jedis;

public static void main(String[] args) {
      jedis = new Jedis("localhost");
      System.out.println("Connection to server sucessfully");
      
     // 获取数据并输出
     Set<String> set = jedis.keys("*");
     List<String> list = new ArrayList<>();
     list.addAll(set);
     for(int i=0; i<list.size(); i++) {
       System.out.println("List of stored keys:: "+list.get(i));
    	 
     }
   }
}