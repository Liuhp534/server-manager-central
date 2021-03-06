package cn.liuhp.simple.server.mq;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.*;
import com.rabbitmq.client.AMQP.BasicProperties;

/**
 * <p>
 * <p>
 * 客户端发送消息，然后接收消息，
 *
 * </p>
 *
 * @author hz16092620
 * @date 2018年9月16日 上午10:27:08
 */
public class DefaultExchange {

    public static void main(String[] args) {
        createClient2();
    }


    /*
    * 模拟客户端发送消息到指定的队列中rpc_liuhp_quene
    * 需要定义一个队列接收消息queneName
    * */
    private static void createClient2() {
        String body = "hi jeff";

        Connection conn = RabbitConnection.createConnection();
        Channel channel = null;
        try {
            channel = conn.createChannel();
            final String queneName = channel.queueDeclare().getQueue();

            final String uuid = UUID.randomUUID().toString();
            BasicProperties props = new BasicProperties().builder().correlationId(uuid).replyTo(queneName).headers(getHeaders()).build();
            channel.basicPublish("", "rpc_liuhp_quene", props, body.getBytes("utf-8"));// 发送消息
            System.out.println("default exchange \"\" 发送消息。。。。接收队列=" + queneName);
            // 接受返回的结果
            Consumer consumer = new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
                    while (true) {
                        if (properties.getCorrelationId().equals(uuid)) {
                            StringBuilder sb = new StringBuilder();
                            for (byte b : body) {
                                sb.append((char) b);
                            }
                            System.out.println(queneName + " 回调队列接收返回的消息: " + sb.toString());
                        }
                        break;
                    }
                }
            };
            Channel consumerChannel = channel;
            Thread consumerThread = new Thread(() -> {
                try {
                    consumerChannel.basicConsume(queneName, true, consumer);
                } catch (Exception e) {
                    System.out.println("处理服务器返回的消息异常");
                }
            });
            consumerThread.start();
            consumerThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != channel) {
                    channel.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static Map<String, Object> getHeaders() {
        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("status", "01");
        headers.put("command", "ins.api.personCheckQuery");
        headers.put("statusText", "预核保结果通知成功");
        headers.put("transNo", "20191104029896");
        return headers;
    }

    /**
     * 交换器发送数据
     */
    public static void createClient() {
        String body = "{\"companyId\":135,\"productId\":101971,\"auditWay\":4,\"resultDetail\":{\"transNo\":\"20191104029896\",\"noHealthPaper\":\"69D9BAAD5C9F40FB922E4AA4E7A4D189\",\"manualTransNo\":\"142661\",\"transDate\":\"2019-11-04T16:44:04.000+0800\",\"resultType\":1,\"resultDesc\":\"\",\"exceptDetailVos\":[{\"exceptContent\":\"\"}],\"expireDate\":\"2019-11-15T16:42:17.000+0800\"}}";

        Connection conn = RabbitConnection.createConnection();
        Channel channel = null;
        try {
            channel = conn.createChannel();
            final String queneName = channel.queueDeclare().getQueue();

            final String uuid = UUID.randomUUID().toString();
            BasicProperties props = new BasicProperties().builder().correlationId(uuid).replyTo(queneName).headers(getHeaders()).build();
            channel.basicPublish("", "pluto_is[task.inscheduler]", props, body.getBytes("utf-8"));// 发送消息
            System.out.println("default exchange \"\" 发送消息。。。。");
            // 接受返回的结果
            // 方式一 queneingConsumer 很多的问题，这个暂时不研究
            // QueueingConsumer consume = new QueueingConsumer(channel);
            /*
             * while (true) { QueueingConsumer.Delivery delivery =
             * consume.nextDelivery(); if
             * (delivery.getProperties().getCorrelationId().equals(uuid)) {
             * System.out.println(new String(delivery.getBody())); } break; }
             */
            // 方式二 defaultConsumer
            /*Consumer consumer = new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
                    while (true) {
                        if (properties.getCorrelationId().equals(uuid)) {
                            StringBuilder sb = new StringBuilder();
                            for (byte b : body) {
                                sb.append((char) b);
                            }
                            System.out.println(queneName + " 回调队列接收返回的消息: " + sb.toString());
                        }
                        break;
                    }
                }
            };
            channel.basicConsume(queneName, true, consumer);*/

            Thread.sleep(1L);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
 