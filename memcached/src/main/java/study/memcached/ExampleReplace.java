package study.memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;
import net.spy.memcached.MemcachedClient;

public class ExampleReplace {
	public static void main(String[] args) {
		try {
			// 连接本地的 Memcached 服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("192.168.111.200", 11211));
			System.out.println("Connection to server sucessful.");
			// 添加第一个 key=》value 对
			Future fo = mcc.set("runoob", 900, "Free Education");
			// 输出执行 add 方法后的状态
			System.out.println("add status:" + fo.get());
			// 获取键对应的值
			System.out.println("runoob value in cache - " + mcc.get("runoob"));
			// 添加新的 key
			fo = mcc.replace("runoob", 900, "Largest Tutorials' Library");
			// 输出执行 set 方法后的状态
			System.out.println("replace status:" + fo.get());
			// 获取键对应的值
			System.out.println("runoob value in cache - " + mcc.get("runoob"));
			// 关闭连接
			mcc.shutdown();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}