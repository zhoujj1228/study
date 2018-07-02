package util;

import redis.clients.jedis.Jedis;

public class RedisHashUtil {
	Jedis jedis;
	public RedisHashUtil(Jedis jedis){
		this.jedis = jedis;
	}
	
	/**
	 * 获取hash
	 * @param key
	 * @param field
	 * @return
	 */
	public String getHash(String key, String field){
		String result = jedis.hget(key, field);
		return result;
	}
	
	/**
	 * 新增hash，存在则修改
	 * @param key
	 * @param field
	 * @param value
	 */
	public void setHash(String key, String field, String value){
		jedis.hset(key, field, value);
	}
	
	/**
	 * 新增hash，不存在才新增
	 * @param key
	 * @param field
	 * @param value
	 */
	public void setHashIfNoExist(String key, String field, String value){
		jedis.hsetnx(key, field, value);
	}
	
}
