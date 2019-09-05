package study.memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;
import net.spy.memcached.MemcachedClient;

public class ExampleDelete {
	public static void main(String[] args) {
		try {
			// 连接本地的 Memcached 服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("192.168.111.200", 11211));
			System.out.println("Connection to server sucessful.");
			// 添加数据
			Future fo = mcc.set("runoob", 900, "World's largest online tutorials library");
			// 输出执行 set 方法后的状态
			System.out.println("set status:" + fo.get());
			// 获取键对应的值
			System.out.println("runoob value in cache - " + mcc.get("runoob"));
			// 对存在的key进行数据添加操作
			fo = mcc.delete("runoob");
			// 输出执行 delete 方法后的状态
			System.out.println("delete status:" + fo.get());
			// 获取键对应的值
			System.out.println("runoob value in cache - " + mcc.get("codingground"));
			// 关闭连接
			mcc.shutdown();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
