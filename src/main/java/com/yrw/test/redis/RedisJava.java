package com.yrw.test.redis;
import redis.clients.jedis.Jedis;
public class RedisJava {
   private static Jedis jedis;

public static void main(String[] args) {
      jedis = new Jedis("localhost");
      System.out.println("Connection to server sucessfully");
      //查看服务是否运行
      System.out.println("Server is running: "+jedis.ping());
 }
}