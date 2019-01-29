package study.rabbitmq.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class RabbitmqUtil {
	public static void main(String[] args) throws UnsupportedEncodingException, IOException, TimeoutException {
		exampleConsumerInfo();
		exampleConsumerTest();
		exampleProvider();
	}

	private static void exampleConsumerInfo() throws IOException, TimeoutException {
		init("192.168.111.200", "test", "test");
		String exchangeName = "testTopic";
		Connection connection = getConnetion();
		Channel channel = getChannel(exchangeName, BuiltinExchangeType.TOPIC, connection);
		List<String> bindingKeys = new ArrayList<String>();
		bindingKeys.add("*.info");
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] exampleConsumerInfo Received '" + envelope.getRoutingKey() + "':'" + message + "'");
			}
		};
		System.out.println("Waiting for messages : exampleConsumerInfo");
		registerConsumer(channel, bindingKeys, exchangeName, consumer);
	}
	
	private static void exampleConsumerTest() throws IOException, TimeoutException {
		init("192.168.111.200", "test", "test");
		String exchangeName = "testTopic";
		Connection connection = getConnetion();
		Channel channel = getChannel(exchangeName, BuiltinExchangeType.TOPIC, connection);
		List<String> bindingKeys = new ArrayList<String>();
		bindingKeys.add("test.*");
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] exampleConsumerTest Received '" + envelope.getRoutingKey() + "':'" + message + "'");
			}
		};
		System.out.println("Waiting for messages : exampleConsumerTest");
		registerConsumer(channel, bindingKeys, exchangeName, consumer);
	}

	private static void exampleProvider() throws UnsupportedEncodingException, IOException, TimeoutException {
		init("192.168.111.200", "test", "test");
		String exchangeName = "testTopic";
		Connection connection = getConnetion();
		Channel channel = getChannel(exchangeName, BuiltinExchangeType.TOPIC, connection);
		providerPutMsg(channel, exchangeName, "test.info", "testMsg1", "UTF-8");
		providerPutMsg(channel, exchangeName, "test.info1", "testMsg2", "UTF-8");
		providerPutMsg(channel, exchangeName, "test1.info", "testMsg3", "UTF-8");
		System.out.println("providerPutMsg end");
		channel.close();
		connection.close();
	}

	static ConnectionFactory factory;
	static Object factoryLock = new Object();
	private static String host;
	private static String user;
	private static String pass;

	public static ConnectionFactory getConnectionFactory() {
		if (factory == null) {
			synchronized (factoryLock) {
				if (factory == null) {
					factory = new ConnectionFactory();
					factory.setHost(host);
					factory.setUsername(user);
					factory.setPassword(pass);

				}
			}
		}
		return factory;
	}

	public static void init(String host, String user, String pass) {
		RabbitmqUtil.host = host;
		RabbitmqUtil.user = user;
		RabbitmqUtil.pass = pass;
	}

	public static Connection getConnetion() throws IOException, TimeoutException {
		Connection connection = getConnectionFactory().newConnection();
		return connection;
	}

	/**
	 * 
	 * @param exchangeName
	 * @param exchangeType
	 *            主要有direct/fanout/headers/topic, 具体看BuiltinExchangeType
	 * @param connection
	 * @return
	 * @throws IOException
	 * @throws TimeoutException
	 */
	public static Channel getChannel(String exchangeName, BuiltinExchangeType exchangeType, Connection connection)
			throws IOException, TimeoutException {
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(exchangeName, exchangeType);
		return channel;
	}

	public static void providerPutMsg(Channel channel, String exchangName, String routingKey, String msg,
			String msgEncode) throws UnsupportedEncodingException, IOException {
		channel.basicPublish(exchangName, routingKey, null, msg.getBytes(msgEncode));
	}

	/**
	 * 
	 * @param channel
	 * @param bindingKeys
	 * @param exchangeName
	 * @param consumer
	 *            可以使用DefaultConsumer(channel)
	 * @throws IOException
	 */
	public static void registerConsumer(Channel channel, List<String> bindingKeys, String exchangeName,
			Consumer consumer) throws IOException {
		String queueName = channel.queueDeclare().getQueue();
		for (String bindingKey : bindingKeys) {
			channel.queueBind(queueName, exchangeName, bindingKey);
		}
		channel.basicConsume(queueName, true, consumer);
	}

}
