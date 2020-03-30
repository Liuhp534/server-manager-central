package cn.liuhp.simple.server.mq;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.*;
import com.rabbitmq.client.AMQP.BasicProperties;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

/**
 * <p>
 * <p>
 * rpc服务器，1、开启队列，2、消费消息，3、把response发送到回调队列。
 *
 * </p>
 *
 * @author hz16092620
 * @date 2018年9月16日 上午10:08:23
 */
public class DefaultExchangeQueue {

    public static void main(String[] args) {
        //consumerMessage();
        server();
    }

    /*
    * 模拟客户端消费消息
    * */
    private static void server() {
        CountDownLatch latch = new CountDownLatch(1);
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(RabbitConnection.HOST);
        connectionFactory.setVirtualHost(RabbitConnection.VIRTUALHOST);
        connectionFactory.setUsername(RabbitConnection.USERNAME);
        connectionFactory.setPassword(RabbitConnection.PASSWORD);
        connectionFactory.setPort(RabbitConnection.PORT);

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("rpc_liuhp_quene");
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        container.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                System.out.println("服务端收到消息=" + message.getBody());
                latch.countDown();
            }
        });
        container.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务端消费消息
     */
    public static void consumerMessage() {
        Connection conn = RabbitConnection.createConnection();
        Channel channel = null;
        try {
            String queneName = "rpc_liuhp_quene";
            channel = conn.createChannel();
            channel.queueDeclare(queneName, true, true, false, null);//这边不能是 排外的队列???
            //operation not permitted on the default exchange 下面这个操作会报错。
            //channel.queueBind(queneName, "", "");//绑定默认的exchange

            //消费消息，推模式
            Channel consumerChannel = channel;
            channel.basicQos(100);//最多消费消息个数
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
                    /*System.out.println(consumerTag);
                    System.out.println(envelope.getDeliveryTag());
                    System.out.println(envelope.getExchange());
                    System.out.println(envelope.getRoutingKey());*/
                    System.out.println("回复队列=" + properties.getReplyTo());
                    StringBuilder sb = new StringBuilder();
                    for (byte b : body) {
                        sb.append((char) b);
                    }
                    System.out.println("消费者消费消息，收到数据: " + sb.toString());
                    BasicProperties props = new BasicProperties().builder().correlationId(properties.getCorrelationId()).build();
                    //consumerChannel.basicAck(envelope.getDeliveryTag(), false);//这个可以确认是否处理消息
                    consumerChannel.basicPublish("", properties.getReplyTo(), props, "result".getBytes());
                }
            };
            Thread serverThread = new Thread(() -> {
                try {
                    while (true) {
                        consumerChannel.basicConsume(queneName, true, consumer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("服务端处理消息异常");
                }
            });
            serverThread.start();
            serverThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != channel) {
                try {
                    System.out.println("channel关闭");
                    channel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("服务端退出");
        }
    }

}
 