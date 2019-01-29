package util;

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

/**
 * 		使用教程:
 *  	//有密码使用
 * 		JedisPool pool = new JedisPool(config, ConfigConstant.redisAddress, ConfigConstant.redisPort, ConfigConstant.redisConnTimeout, "password"); 
 * 		
 *  	Jedis jedis = pool.getResource(); 	
 * 		String value = jedis.get("key"); 
 * 		jedis.close();
 *  	pool.close();
 * 		
 * 		配置设置教程:
 * 		public void setConfig(GenericObjectPoolConfig conf) {
 *			setLifo(conf.getLifo());
 *			setMaxIdle(conf.getMaxIdle());
 *			setMinIdle(conf.getMinIdle());
 *			setMaxTotal(conf.getMaxTotal());
 *			setMaxWaitMillis(conf.getMaxWaitMillis());
 *			setBlockWhenExhausted(conf.getBlockWhenExhausted());
 *			setTestOnCreate(conf.getTestOnCreate());
 *			setTestOnBorrow(conf.getTestOnBorrow());
 *			setTestOnReturn(conf.getTestOnReturn());
 *			setTestWhileIdle(conf.getTestWhileIdle());
 *			setNumTestsPerEvictionRun(conf.getNumTestsPerEvictionRun());
 *			setMinEvictableIdleTimeMillis(conf.getMinEvictableIdleTimeMillis());
 *			setTimeBetweenEvictionRunsMillis(
 *			        conf.getTimeBetweenEvictionRunsMillis());
 *			setSoftMinEvictableIdleTimeMillis(
 *			        conf.getSoftMinEvictableIdleTimeMillis());
 *			setEvictionPolicyClassName(conf.getEvictionPolicyClassName());
 * 		}
 * 		
 * 		
 * 		连接池构造参数教程:
 * 		public JedisFactory(final String host, final int port, final int connectionTimeout,
 * 			      final int soTimeout, final String password, final int database, final String clientName,
 * 			      final boolean ssl, final SSLSocketFactory sslSocketFactory, final SSLParameters sslParameters,
 * 			      final HostnameVerifier hostnameVerifier) {
 * 			this.hostAndPort.set(new HostAndPort(host, port));
 * 			this.connectionTimeout = connectionTimeout;
 * 			this.soTimeout = soTimeout;
 * 			this.password = password;
 * 			this.database = database;
 * 			this.clientName = clientName;
 * 			this.ssl = ssl;	
 * 			this.sslSocketFactory = sslSocketFactory;@author Jay
 * 			this.sslParameters = sslParameters;@date 2018年12月29日
 *			this.hostnameVerifier = hostnameVerifier;
 *   	}
 *   
 */
public class RedisUtil {
	private static ShardedJedisPool shardedJedisPool;
	private static JedisPool jedisPool;
	private static JedisSentinelPool sentinelJedisPool;
	private static Jedis singelInstance;
	public static ShardedJedisPool getShardedJedisPool() {
		return shardedJedisPool;
	}
	public static JedisSentinelPool getSentinelJedisPool() {
		return sentinelJedisPool;
	}
	public static Jedis getSingleJedisInstance(){
		return singelInstance;
	}
	public static Jedis initSingleJedisInstance(String ip, int port){
		return singelInstance = new Jedis(ip, port);
	}
	
	public static Jedis getJedisPoolInstance(){
		Jedis jedis = jedisPool.getResource();
		return jedis;
	}
	
	public static boolean delHashByKey(String key){
		Set<String> delHashField = singelInstance.hkeys(key);
		for(String field : delHashField){
			singelInstance.hdel(key, field);
		}
		return true;
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
		Set<String> sentinels = new HashSet<>(); 
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
		List jdsInfoList = new ArrayList<>(2);
		for (int i = 0; i < addrs.size(); i++) {
			jdsInfoList.add(new JedisShardInfo(addrs.get(i), ports.get(i)));
		}
		shardedJedisPool = new ShardedJedisPool(config, jdsInfoList, Hashing.MURMUR_HASH, Sharded.DEFAULT_KEY_TAG_PATTERN); 
	}
}
