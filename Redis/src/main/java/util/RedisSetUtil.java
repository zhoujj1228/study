package util;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisSetUtil {
	Jedis jedis;
	public RedisSetUtil(Jedis jedis){
		this.jedis = jedis;
	}
	
	public Long add(String key, String... members){
		return jedis.sadd(key, members);
	}
	
	public Long remove(String key, String... members){
		return jedis.srem(key, members);
	}
	
	public Long changeSet(String srckey, String dstkey, String member){
		return jedis.smove(srckey, dstkey, member);
	}
	
	public Set<String> getUnionSet(String... keys){
		return jedis.sunion(keys);
	}
	
	public Set<String> getDiffSet(String... keys){
		return jedis.sdiff(keys);
	}
	
	public Set<String> getInterSet(String... keys){
		return jedis.sinter(keys);
	}
	
	public Set<String> getAll(String key){
		return jedis.smembers(key);
	}
	
	public Boolean isExist(String key, String member){
		return jedis.sismember(key, member);
	}
}
