package util;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.Jedis;
import util.other.CloneObjectUtil;

public class RedisObjUtil {
	private static final Log log = LogFactory.getLog(RedisObjUtil.class);
	
	private static String charset = "UTF-8";;
	
	public static boolean setObj(String key, Object obj, Jedis jedis){
		try {
			byte[] keyBytes = key.getBytes(charset);
			byte[] objBytes = CloneObjectUtil.deepCloneObjectToByteArray(obj);
			jedis.set(keyBytes, objBytes);
			return true;
		} catch (IOException e) {
			log.error("can not setObj to redis cache", e);
			return false;
		}
	}
	public static Object getObj(String key, Jedis jedis){
		byte[] objBytes = null;
		try {
			objBytes = jedis.get(key.getBytes(charset));
			Object obj = CloneObjectUtil.deepCloneByteArrayToObject(objBytes);
			return obj;
		} catch (UnsupportedEncodingException e) {
			log.error("can not transfer key to bytes", e);
			return null;
		} catch (ClassNotFoundException e) {
			log.error("can not transfer bytes to object", e);
			return null;
		} catch (IOException e) {
			log.error("can not transfer bytes to object", e);
			return null;
		}
	}
}

