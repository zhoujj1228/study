package util;

import redis.clients.jedis.Jedis;

public class RedisHyperLogUtil {
	Jedis jedis;
	public RedisHyperLogUtil(Jedis jedis){
		this.jedis = jedis;
	}
	
	public Long add(String key, String... elements){
		return jedis.pfadd(key, elements);
	}
	
	/**
	 * 获取某个key的HyperLogLog的近似基数
	 * @param key
	 * @return
	 */
	public Long count(String key){
		return jedis.pfcount(key);
	}
	
	/**
	 * 将多个 HyperLogLog 合并（merge）为一个 HyperLogLog 
	 * @param destkey
	 * @param sourcekeys
	 * @return 成功返回OK
	 */
	public String merge(String destkey, String... sourcekeys){
		return jedis.pfmerge(destkey, sourcekeys);
	}
}
