package example;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


/**
 * NIO服务器例子
 * 
 * ByteBuffer.flip()	从缓冲区中读取数据时调用flip方法
 * ByteBuffer.clear()	重新写缓冲区
 * ByteBuffer.rewind()
 * 主要是以下不同
 * position 当前位置
 * limit 越界位置
 * mark 取消标志
 * 上面方法基本只用于读操作，写操作最好使用另一个缓冲区
 * 
 * selector在某一时刻只对一种事件进行监听
 * @author Jay
 * @date 2018年7月2日
 */
public class MyNIOServer implements Runnable{
//	ByteBuffer buffer = ByteBuffer.allocate(5);
	ByteBuffer buffer = ByteBuffer.allocate(1024);
	String defaultRspMsg = "serverOK";
	public static void main(String[] args) {
		
		new Thread(new MyNIOServer()).start();
	}
	
	@Override
	public void run() {
		Selector selector = null;
		ServerSocketChannel serverChannel = null;
		try {
			// 实例化selector
			selector = Selector.open();
			// 实例化serverChannel
			serverChannel = ServerSocketChannel.open();
			// 设置为非阻塞方式，如果为true那么就为传统的阻塞方式
			serverChannel.configureBlocking(false);
			//绑定ip和端口
			serverChannel.socket().bind(new InetSocketAddress("11.8.123.208",6666));
			//注册OP_ACCEPT事件
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("开始监听");
		while(true){
			try {
				int i = selector.select();
				if(i == 0){
					continue;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> iter = keys.iterator();

			while(iter.hasNext()){
				SelectionKey key = iter.next();
				iter.remove();
				if(key.isAcceptable()){
					System.out.println("收到连接请求start");
					ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
					SocketChannel sc = null;
					try {
						sc = ssc.accept();
						if(sc != null){
							sc.configureBlocking(false);
							sc.register(selector, SelectionKey.OP_READ);
						}
						
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("收到连接请求end");
					
				}
				if(key.isReadable()){
					System.out.println("server收到读取请求");
					SocketChannel sc = null;
					sc = (SocketChannel) key.channel();
					
					int i;
					try {
						i = sc.read(buffer);
						buffer.flip();
						if(i == -1){
							System.out.println("read fail");
						}else{
							String result = "";
							ByteArrayOutputStream bio = new ByteArrayOutputStream();
							while(buffer.hasRemaining()){
								byte c = buffer.get();
								bio.write(c);
							}
							result = bio.toString("UTF-8");
							System.out.println("read success:"+result);
						}
					} catch (IOException e) {
						e.printStackTrace();
						try {
							sc.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

					buffer.clear();
					key.interestOps(SelectionKey.OP_WRITE);
					
					
				}
				if(key.isWritable()){
					System.out.println("server收到写入请求");
					ByteBuffer block = ByteBuffer.wrap(defaultRspMsg.getBytes());
					SocketChannel sc = null;
					sc = (SocketChannel) key.channel();
					try {
						sc.write(block);
						System.out.println("server 写入成功");
					} catch (IOException e) {
						e.printStackTrace();
					}
					key.interestOps(SelectionKey.OP_READ);
				}
				
			}
				
				
			
		}
	}
	
}
