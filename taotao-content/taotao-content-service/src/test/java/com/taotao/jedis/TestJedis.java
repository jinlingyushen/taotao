package com.taotao.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestJedis {
	
	@Test
	public void testJedis(){
		//创建一个jedis对象，需要指定服务的ip和端口号
		Jedis jedis = new Jedis("192.168.163.89",6379);
		jedis.set("jedis-key", "1111");
		System.out.println(jedis.get("jedis-key"));
		jedis.close();
		
	}
}
