package study.memcached;

import net.spy.memcached.MemcachedClient;
import java.net.*;

public class ExampleConnect {
	public static void main(String[] args) {
		try {
			// 本地连接 Memcached 服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("192.168.111.200", 11211));
			System.out.println("Connection to server sucessful.");
			// 关闭连接
			mcc.shutdown();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
