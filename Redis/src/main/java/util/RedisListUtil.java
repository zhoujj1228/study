package util;

import redis.clients.jedis.Jedis;

public class RedisListUtil {
	Jedis jedis;
	public RedisListUtil(Jedis jedis){
		this.jedis = jedis;
	}
	
	public String getHeadAndRemove(String key){
		return jedis.lpop(key);
	}
	
	public String getTailAndRemove(String key){
		return jedis.rpop(key);
	}
	
	public Long setHead(String key, String value){
		return jedis.lpush(key, value);
	}
	
	public Long setTail(String key, String value){
		return jedis.rpush(key, value);
	}
	
	public String setIndexValue(String key, long index, String value){
		return jedis.lset(key, index, value);
	}
}
