package init;

import redis.clients.jedis.Jedis;

public class RedisInitializer {
	private static Jedis instance = new Jedis("127.0.0.1", 6379);
	public static Jedis getJedisInstance(){
		return instance;
	}
}
