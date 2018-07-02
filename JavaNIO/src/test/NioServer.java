package test;
//������

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.CharBuffer;

import java.util.Iterator;

import java.io.IOException;

//���ڷ������ķ�����ʵ��
public class NioServer {

	private static int DEFAULT_PORT = 6545;
	private static int DEFAULT_BUFFERSIZE = 1023;
	private static String DEFAULT_CHARSET = "UTF-8";

	private ServerSocketChannel ss;
	private Selector selector;

	private ByteBuffer buffer;
	private Charset charset;
	private CharsetDecoder decoder;
	private int port;

	public NioServer() throws IOException {

		this.port = DEFAULT_PORT;
		this.ss = null;
		this.selector = Selector.open();
		this.buffer = ByteBuffer.allocate(DEFAULT_BUFFERSIZE);
		this.charset = Charset.forName(DEFAULT_CHARSET);
		this.decoder = this.charset.newDecoder();

	}
	

	public static void main(String[] args) throws IOException {
		System.out.println("���������� ");
		NioServer server = new NioServer();
		server.listen(); // ��������ʼ�����˿ڣ��ṩ����
	}
	

	public void listen() throws IOException {
		// ��������ʼ�����˿ڣ��ṩ����
		ServerSocket socket;
		ss = ServerSocketChannel.open(); // ��ͨ��
		socket = ss.socket(); // �õ���ͨ����ص�socket����
		socket.bind(new InetSocketAddress(port)); // ��scoket�����ƶ��Ķ˿���
		// ����ͨ��ʹ�÷�����ģʽ���ڷ�����ģʽ�£����Ա�д�������ͬʱ����ʹ�ø��ӵĶ��߳�
		ss.configureBlocking(false);
		ss.register(selector, SelectionKey.OP_ACCEPT);
		try {
			while (true) {
				// ��ͨ���ĳ���ͬ������ʹ��channel.accpet()���ܿͻ����������󣬶�������socket�����ϵ���accept(),
				// �����ڵ���accept()����ʱ���ͨ������Ϊ������ģʽ,��ôaccept()������������null����������
				this.selector.select();
				Iterator<SelectionKey> iter = this.selector.selectedKeys().iterator();
				while (iter.hasNext()) {
					SelectionKey key = (SelectionKey) iter.next();
					iter.remove();
					this.handlerKey(key);

				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			this.ss.close();
		}
	}
	

	// ����key
	public void handlerKey(SelectionKey key) throws IOException {

		if (key.isAcceptable()) {

			System.out.println("one client coming");
			// ȡ����Ӧ�ķ�����ͨ��
			ServerSocketChannel server = (ServerSocketChannel) key.channel();
			// ��Ӧsocketchannel
			SocketChannel channel = server.accept();
			channel.configureBlocking(false);
			// �ɶ�
			channel.register(selector, SelectionKey.OP_READ);
		} else if (key.isReadable()) {

			SocketChannel channel = (SocketChannel) key.channel();

			int count = channel.read(this.buffer);
			System.out.println("��ʼread");
			if (count > 0) {
				// �Ѽ�����Ϊλ�ã���λ����Ϊ0��������ȡbufferʱ���պö�ȡ���Ѿ���ȡ�������ݵ�buffer
				this.buffer.flip();

				CharBuffer charBuffer = decoder.decode(this.buffer);
				String message = charBuffer.toString();
				// ����˽��տͻ�����������
				System.out.println("server:" + message);
				// NioSession data = new NioSession(message);

				// �л�Ϊд�¼�
				key.interestOps(SelectionKey.OP_WRITE);
				// channel.register(selector, SelectionKey.OP_WRITE);
				key.attach(message);

			} else { // �ͻ��Ѿ��Ͽ�
				channel.close();
			}
			// �Ѽ�����Ϊ�������ٰ�λ����Ϊ0��
			// this.buffer.clear();//��ջ�����,Ϊ��һ�ν���������׼��

			// ���޲��䣬�ٰ�λ����Ϊ0����������ʼ��ʱbuffer��һ����
			this.buffer.rewind();
		} else if (key.isWritable() && key.isValid()) {

			SocketChannel channel = (SocketChannel) key.channel();
			// NioSession handle = (NioSession) key.attachment();//ȡ��������
			String message = "re:" + ((String) key.attachment());
			// handle.setGreeting(message);
			ByteBuffer block = ByteBuffer.wrap(message.getBytes());
			channel.write(block);
			// �л�Ϊ���¼�
			key.interestOps(SelectionKey.OP_READ);
			// ��ʱ����ע��һ�����¼�ʱ�������ô˷���ʱ��register�������¼��Ѿ�����ʱ��
			// channel.register(selector,SelectionKey.OP_READ);
		}
	}


}