package cn.liuhp.mq;

import cn.liuhp.base.RabbitConnection;
import com.rabbitmq.client.*;
import com.rabbitmq.client.AMQP.BasicProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

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
@Configuration
public class DefaultExchangeQueue {

    private static final Logger logger = LoggerFactory.getLogger(DefaultExchangeQueue.class);

    public static void main(String[] args) {
        //consumerMessage();
        //server();
    }

    /*
    * 模拟客户端消费消息
    * */
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        logger.info("开启mq服务端消费");
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
            }
        });
        return container;
        //container.start();//main方法执行需要手动启动，给spring的话通过Lifecycle接口管理
    }



}
 