package cn.huse.jedis;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class Jedis2Test {
	Jedis jedis;
	@Before
	public void createJedis() {
		jedis = new Jedis("192.168.164.128");
		//设置密码
		jedis.auth("admin");	
	}
	
	// keys patten
		@Test
		public void keyspatten(){
			Set<String> keys = jedis.keys("*");
			System.out.println(keys);
			
			// delete
			Long del = jedis.del("foo");
			System.out.println(del);
			
			jedis.expire("username", 100); //设置生命周期为100秒
			//jedis.persist("username");
			Long ttl = jedis.ttl("username"); //获取生命周期值
			System.out.println(ttl);
		}
	
	// 获取分数元素 zrangeWithScores
	@Test
	public void zrangeWithScores() {
		Map<String, Double> sm = new HashMap<String, Double>();
		sm.put("张三", 70.0);
		sm.put("李四", 80.0);
		sm.put("王五", 90.0);
		sm.put("赵六", 60.0);
		jedis.zadd("zkey", sm);
		Set<String> set = jedis.zrange("zkey", 0, -1);
		System.out.println(set);
		
		// 根据分数获取
		Set<String> set1 = jedis.zrangeByScore("zkey", 70.0, 90.0);
		System.out.println(set1);
		sm = new HashMap<String, Double>();
		sm.put("张三", 70.0);
		sm.put("李四", 80.0);
		sm.put("王五", 90.0);
		sm.put("赵六", 60.0);
		jedis.zadd("zkey", sm);
		Set<Tuple> zws = jedis.zrangeWithScores("zkey", 0, -1);
		for (Tuple t : zws) {
			System.out.println(t.getScore() + "  " + t.getElement());
		}
		
		// get score
		Double zscore = jedis.zscore("zkey", "张三");
		System.out.println(zscore);
		
		// remove
		jedis.zrem("zkey", "李四");
		zws = jedis.zrangeWithScores("zkey", 0, -1);
		for (Tuple t : zws) {
			System.out.println(t.getScore() + "  " + t.getElement());
		}
		
	}

	//差集 sdiff
		@Test
		public void sdiff(){
			//差集
			jedis.sadd("language1","java","c++","ruby","python");
			jedis.sadd("language2","ios","c++","c#","android");
			
			Set<String> sdiff = jedis.sdiff("language1","language2");
			System.out.println(sdiff);
			
			//交集
			Set<String> sinter = jedis.sinter("language1","language2");
			System.out.println(sinter);
			
			// 并集
			Set<String> sunion = jedis.sunion("language1","language2");
			System.out.println(sunion);
		}
	
	
	//演示sadd smembers
		@Test
		public void smembers(){
			
			jedis.sadd("language1","java","c++","ruby","python");
			
			Set<String> smembers = jedis.smembers("language1");
			System.out.println(smembers);
			
			// remove
			jedis.srem("language1", "java");
			smembers = jedis.smembers("language1");
			System.out.println(smembers);
		}
	
	
	@Test
	public void lpushTest() {
		// 
//		jedis.lpush("names", "tom","james","zhang","li");
//		List<String>names = jedis.lrange("names", 0, -1);
//		System.out.println(names);
	
		//insert
		jedis.linsert("names", LIST_POSITION.BEFORE, "james", "fox");
		List<String>names = jedis.lrange("names", 0, -1);
		System.out.println(names);
		
		// delete
		jedis.lrem("names", 1, "james");
		names = jedis.lrange("names", 0, -1);
		System.out.println(names);
		
		// hset hget
		jedis.hset("user", "username", "tom");
		String value = jedis.hget("user","username");
		System.out.println(value);
		
		// hash
		Map<String,String>hash = new HashMap<String,String>();
		hash.put("passwd", "123");
		hash.put("sex", "male");
		jedis.hmset("user", hash);
		
		names = jedis.hmget("user","username","password","sex");
		System.out.println(names);
		
		//map
		Map<String, String> map = jedis.hgetAll("user");
		for(String key:map.keySet()){
			System.out.println(key+"  "+map.get(key));
		}
		
		Set<String> keys = jedis.hkeys("user");
		System.out.println(keys);
		List<String> values = jedis.hvals("user");
		System.out.println(values);
		
		// del
		jedis.hdel("user", "username","password");
		map = jedis.hgetAll("user");
		for(String key:map.keySet()){
			System.out.println(key+"  "+map.get(key));
		}
	}

	@Test
	public void test() {	
		jedis.append("username","is boy");
		jedis.setrange("username",7," girl");
		System.out.println(jedis.getrange("username", 7, -1));
		
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);
		
		jedis.mset("password","123","age","20");
		List<String>values = jedis.mget("username","password","age");
		System.out.println(values);
	}
}










