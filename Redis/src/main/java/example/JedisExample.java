package example;

import init.RedisInitializer;
import redis.clients.jedis.Jedis;
import util.RedisHashUtil;
import util.RedisStringUtil;

public class JedisExample {

	public static void main(String[] args) {
		new JedisExample().call();
	}

	private void call() {
		Jedis jedis = RedisInitializer.getJedisInstance();
		/*RedisHashUtil rhu = new RedisHashUtil(jedis);
		rhu.setHash("jtestkey1", "jtestfield1", "jtestvalue1");
		System.out.println(rhu.getHash("jtestkey1", "jtestfield1"));*/
		
		RedisStringUtil rsu = new RedisStringUtil(jedis);
		System.out.println(rsu.getString("test3"));
		
	}

}
