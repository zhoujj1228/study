package study.rabbitmq;

/**
 * 1.channel.queueDeclare(String queue, boolean durable, boolean exclusive, 
 * 		boolean autoDelete, Map<String, Object> arguments)
 * 其中：
 * queue为队列名，为空(不能为null)则由服务器自动生成
 * durable 是否持久化，持久化数据在服务器重启后还能够存活
 * exclusive 是否为当前连接的专用队列，在连接断开后，会自动删除该队列
 * autoDelete 是否自动删除，当最后一个消费者断开连接之后队列是否自动被删除
 * arguments 其他配置
 * 
 * @author Jay
 * @date 2018年7月3日
 */
public class Study {
	
}
