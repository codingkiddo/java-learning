package com.example.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class MemcachedJava {
   public static void main(String[] args) throws IOException {
      
      // Connecting to Memcached server on localhost
      MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
      System.out.println("Connection to server sucessfully");
      
      //not set data into memcached server
      System.out.println("set status:"+mcc.set("tutorialspoint", 900, "memcached").isDone());
      
      //Get value from cache
      System.out.println("Get from Cache:"+mcc.get("tutorialspoint"));
   }
}
