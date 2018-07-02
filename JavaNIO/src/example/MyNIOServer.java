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
 * NIO����������
 * 
 * ByteBuffer.flip()	�ӻ������ж�ȡ����ʱ����flip����
 * ByteBuffer.clear()	����д������
 * ByteBuffer.rewind()
 * ��Ҫ�����²�ͬ
 * position ��ǰλ��
 * limit Խ��λ��
 * mark ȡ����־
 * ���淽������ֻ���ڶ�������д�������ʹ����һ��������
 * 
 * selector��ĳһʱ��ֻ��һ���¼����м���
 * @author Jay
 * @date 2018��7��2��
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
			// ʵ����selector
			selector = Selector.open();
			// ʵ����serverChannel
			serverChannel = ServerSocketChannel.open();
			// ����Ϊ��������ʽ�����Ϊtrue��ô��Ϊ��ͳ��������ʽ
			serverChannel.configureBlocking(false);
			//��ip�Ͷ˿�
			serverChannel.socket().bind(new InetSocketAddress("11.8.123.208",6666));
			//ע��OP_ACCEPT�¼�
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("��ʼ����");
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
					System.out.println("�յ���������start");
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
					System.out.println("�յ���������end");
					
				}
				if(key.isReadable()){
					System.out.println("server�յ���ȡ����");
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
					System.out.println("server�յ�д������");
					ByteBuffer block = ByteBuffer.wrap(defaultRspMsg.getBytes());
					SocketChannel sc = null;
					sc = (SocketChannel) key.channel();
					try {
						sc.write(block);
						System.out.println("server д��ɹ�");
					} catch (IOException e) {
						e.printStackTrace();
					}
					key.interestOps(SelectionKey.OP_READ);
				}
				
			}
				
				
			
		}
	}
	
}
