package com.taotao.jedis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestJedisSpring {
	
	@Test
	public void testJedisPoolSpring(){
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
		JedisClientPool jedisClientPool = 
				applicationContext.getBean("jedisClientPool",JedisClientPool.class);
		jedisClientPool.set("key4","jack");
		String result = jedisClientPool.get("key4");
		System.out.println(result);
	}
	
	@Test
	public void testJedisClusterSpring(){
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
		JedisClientCluster jedisClientCluster = 
				applicationContext.getBean("jedisClientCluster",JedisClientCluster.class);
		jedisClientCluster.set("key5", "qwertyuuioo");
		String result = jedisClientCluster.get("key5");
		System.out.println(result);
	}

}
