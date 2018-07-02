package util;

import redis.clients.jedis.Jedis;

public class RedisStringUtil {
	Jedis jedis;
	public RedisStringUtil(Jedis jedis){
		this.jedis = jedis;
	}
	/**
	 * 获取redis字符串
	 * @param key
	 * @return
	 */
	public String getString(String key){
		String result = jedis.get(key);
		return result;
	}
	
	/**
	 * 新增redis字符串，存在则替换
	 * @param key
	 * @param value
	 * @return
	 */
	public String setString(String key, String value){
		return jedis.set(key, value);
	}
	
	/**
	 * 新增redis字符串，不存在才新增
	 * @param key
	 * @param value
	 * @return 已存在返回0，成功返回1
	 */
	public Long setStringIfNoExist(String key, String value){
		return jedis.setnx(key, value);
	}
	
	
	/**
	 * 删除redis字符串
	 * @param key
	 * @return 
	 */
	public Long setString(String key){
		return jedis.del(key);
	}
}
