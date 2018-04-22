package com.taotao.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestJedisPool {
	
	@Test
	public void testJedisPool(){
		JedisPool jedisPool = new JedisPool("192.168.163.89", 6379);
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get("jedis-key");
		System.out.println(result);
		jedis.close();
		jedisPool.close();
	}

}
