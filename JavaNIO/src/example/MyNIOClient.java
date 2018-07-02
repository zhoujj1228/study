package example;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class MyNIOClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Selector selector = null;
		SocketChannel channel = null;
		try {
			// 实例化selector
			selector = Selector.open();
			// 绑定ip和端口
			channel = SocketChannel.open(new InetSocketAddress("11.8.123.208",6666));
			// 设置为非阻塞方式，如果为true那么就为传统的阻塞方式
			channel.configureBlocking(false);
			
			while(!channel.finishConnect()){
				System.out.println("no connect complete");
			}
			//客户端注册connect和accept没用
			
			channel.register(selector, SelectionKey.OP_WRITE);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("client 开始接入");

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
				if(key.isReadable()){
					System.out.println("client接收到读请求");
					SocketChannel sc = null;
					sc = (SocketChannel) key.channel();
					ByteBuffer b = ByteBuffer.allocate(1024);
					int i;
					try {
						i = sc.read(b);
						b.flip();
						System.out.println(i);
						if(i == -1){
							System.out.println("失败");
						}else{
							String result = "";
							while(b.hasRemaining()){
								result +=String.valueOf((char)b.get());
							}
							System.out.println("success:"+result);
						}
					} catch (IOException e) {
						e.printStackTrace();
						try {
							sc.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
				}
				
				if(key.isWritable()){
					String message = "1234567890abcde";
					ByteBuffer block = ByteBuffer.wrap(message.getBytes());
					
					System.out.println("client收到写入请求");
					SocketChannel sc = null;
					sc = (SocketChannel) key.channel();
					try {
						sc.write(block);
						System.out.println("client 写入成功");
					} catch (IOException e) {
						e.printStackTrace();
					}
					key.interestOps(SelectionKey.OP_READ);
				}
			}
		}
	}

}
