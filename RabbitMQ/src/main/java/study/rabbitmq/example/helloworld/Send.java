package study.rabbitmq.example.helloworld;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 第一个例子，使用非持久化队列，生产者发布消息，MQ 将消息推送给消费者消费，之后 MQ 在队列中删除该消息
 * @author Jay
 * @date 2018年7月3日
 */
public class Send {

  private final static String QUEUE_NAME = "hello";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("192.168.241.128");
    factory.setUsername("test");
    factory.setPassword("test");
    //factory.setVirtualHost("/");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    String message = "Hello World!";
    channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
    System.out.println(" [x] Sent '" + message + "'");

    channel.close();
    connection.close();
  }
}
