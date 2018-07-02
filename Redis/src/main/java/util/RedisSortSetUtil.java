package util;

import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisSortSetUtil {
	Jedis jedis;
	public RedisSortSetUtil(Jedis jedis){
		this.jedis = jedis;
	}
	
	public Long add(String key, Map<String, Double> scoreMembers){
		return jedis.zadd(key, scoreMembers);
	}
	
	public Long remove(String key, String... members){
		return jedis.zrem(key, members);
	}
	
	public Long removeByIndex(String key, long start, long end){
		return jedis.zremrangeByRank(key, start, end);
	}
	
	public Long removeByScore(String key, String start, String end){
		return jedis.zremrangeByScore(key, start, end);
	}
	
	public Long removeByDoubleScore(String key, double start, double end){
		return jedis.zremrangeByScore(key, start, end);
	}
	
	public Set<String> getByIndex(String key, long start, long end){
		return jedis.zrange(key, start, end);
	}
	
	public Set<String> getByScore(String key, String min, String max){
		return jedis.zrangeByScore(key, min, max);
	}
	
	public Set<String> getByDoubleScore(String key, double min, double max){
		return jedis.zrangeByScore(key, min, max);
	}
	
	public Set<String> getAll(String key){
		return jedis.zrange(key, 0, -1);
	}
	
	public Long getIndex(String key, String member){
		return jedis.zrank(key, member);
	}
	
	public double getScore(String key, String member){
		return jedis.zscore(key, member);
	}
}
