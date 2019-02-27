package init;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import util.pool.RedisPoolUtil;

public class RedisInitializer {
	private static Jedis instance = new Jedis("192.168.111.200", 6479);
	public static Jedis getJedisInstance(){
		return instance;
	}
	
	public static void initRedis(){
		List<String> sentinelAddressList = new ArrayList<String>();
		sentinelAddressList.add("192.168.111.200:16379");
		sentinelAddressList.add("192.168.111.200:16380");
		sentinelAddressList.add("192.168.111.200:16381");
		RedisPoolUtil.initSentinelJedisPool("mymaster", sentinelAddressList);
	}
}
