package study.rabbitmq.example.helloworld;
import com.rabbitmq.client.*;

import java.io.IOException;
/**
 * 第一个例子，使用非持久化队列，生产者发布消息，MQ 将消息推送给消费者消费，之后 MQ 在队列中删除该消息
 * @author Jay
 * @date 2018年7月3日
 */
public class Recv {

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
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
          throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
      }
    };
    channel.basicConsume(QUEUE_NAME, true, consumer);
  }
}
