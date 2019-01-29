package init;

import redis.clients.jedis.Jedis;

public class RedisInitializer {
	private static Jedis instance = new Jedis("192.168.111.200", 6479);
	public static Jedis getJedisInstance(){
		return instance;
	}
}
