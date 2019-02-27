package example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import util.RedisUtil;

public class SentinelExample {
	public static void main(String[] args) throws IOException {
		List<String> sentinelAddressList = new ArrayList<>();
		sentinelAddressList.add("192.168.111.200:16379");
		sentinelAddressList.add("192.168.111.200:16380");
		sentinelAddressList.add("192.168.111.200:16381");
		RedisUtil.initSentinelJedisPool("mymaster", sentinelAddressList);
		JedisSentinelPool sentinelJedisPool = RedisUtil.getSentinelJedisPool();
		Jedis resource = sentinelJedisPool.getResource();
		String string1 = resource.get("test");
		System.out.println(string1);
		resource.set("test", "testSentinelValue2");
		resource.close();
		System.out.println("input:");
		Scanner scanner = new Scanner(System.in);
		String flag = scanner.nextLine();
		if(flag.equals("0")){
			System.exit(0);
		}
		Jedis resource1 = sentinelJedisPool.getResource();
		String string = resource1.get("test");
		System.out.println(string);
		
	}
}
