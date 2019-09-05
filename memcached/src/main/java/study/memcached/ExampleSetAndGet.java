package study.memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;
import net.spy.memcached.MemcachedClient;

public class ExampleSetAndGet {
	public static void main(String[] args) {
		try {
			// 连接本地的 Memcached 服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("192.168.111.200", 11211));
			System.out.println("Connection to server sucessful.");
			// 存储数据
			Future fo = mcc.set("runoob", 900, "Free Education");
			// 查看存储状态
			System.out.println("set status:" + fo.get());
			// 输出值
			System.out.println("runoob value in cache - " + mcc.get("runoob"));
			// 关闭连接
			mcc.shutdown();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
