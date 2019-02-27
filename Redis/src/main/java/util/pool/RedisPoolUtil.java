package util.pool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

public class RedisPoolUtil {
	public static ShardedJedisPool shardedJedisPool;
	public static JedisPool jedisPool;
	public static JedisSentinelPool sentinelJedisPool;
	public static Jedis singelInstance;
	public static void initSingleJedisInstance(String ip, int port){
		singelInstance = new Jedis(ip, port);
	}
	
	public static void initSimpleJedisPool(String ip, int port, int connTimeout, int maxIdle, int maxTotal){
		JedisPoolConfig config = new JedisPoolConfig(); 
		//最大空闲连接数
		config.setMaxIdle(maxIdle);
		//最大连接数
		config.setMaxTotal(maxTotal);
		jedisPool = new JedisPool(config, ip, port, connTimeout); 
		
	}
	
	public static void initSimpleJedisPool(String ip, int port, int connTimeout, int maxIdle, int maxTotal, int minIdle){
		JedisPoolConfig config = new JedisPoolConfig(); 
		config.setMaxIdle(maxIdle);
		config.setMaxTotal(maxTotal);
		config.setMinIdle(minIdle);
		jedisPool = new JedisPool(config, ip, port, connTimeout);
		
	}
	
	/**
	 * 使用主备哨兵模式的使用
	 * @param masterName 通常为sentinel.conf配置文件中的sentinel monitor mymaster 127.0.0.1 6379 2其中的mymaster
	 * @return 
	 */
	public static void initSentinelJedisPool(String masterName, List<String> sentinelAddressList){
		Set<String> sentinels = new HashSet<String>(); 
		//sentinels.add("172.18.18.207:26379"); 
		//sentinels.add("172.18.18.208:26379");
		//sentinels.add(mainAddress);
		//sentinels.add(slaveAddress);
		for(String addr : sentinelAddressList){
			sentinels.add(addr);
		}
		
		JedisPoolConfig config = new JedisPoolConfig(); 
		config.setMaxIdle(5); 
		config.setMaxTotal(20); 
		sentinelJedisPool = new JedisSentinelPool(masterName, sentinels, config);
	}
	
	/**
	 * 使用分片模式进行集群的Redis连接池
	 * 注意分片类型
	 * @param addrs
	 * @param ports
	 */
	public static void initShardedJedisPool(List<String> addrs, List<String> ports){
		JedisPoolConfig config = new JedisPoolConfig(); 
		config.setMaxTotal(500); 
		config.setTestOnBorrow(true); 
		List<JedisShardInfo> jdsInfoList = new ArrayList<JedisShardInfo>(2);
		for (int i = 0; i < addrs.size(); i++) {
			jdsInfoList.add(new JedisShardInfo(addrs.get(i), ports.get(i)));
		}
		shardedJedisPool = new ShardedJedisPool(config, jdsInfoList, Hashing.MURMUR_HASH, Sharded.DEFAULT_KEY_TAG_PATTERN); 
	}
}
