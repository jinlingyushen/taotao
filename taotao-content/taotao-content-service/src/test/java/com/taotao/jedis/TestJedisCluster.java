package com.taotao.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class TestJedisCluster {
	
	@Test
	public void testJedisCluster(){
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.163.89", 7001));
		nodes.add(new HostAndPort("192.168.163.89", 7002));
		nodes.add(new HostAndPort("192.168.163.89", 7003));
		nodes.add(new HostAndPort("192.168.163.89", 7004));
		nodes.add(new HostAndPort("192.168.163.89", 7005));
		nodes.add(new HostAndPort("192.168.163.89", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("jedis-cluster", "wangjie");
		jedisCluster.get("jedis-cluster");
		jedisCluster.close();
	}

}
