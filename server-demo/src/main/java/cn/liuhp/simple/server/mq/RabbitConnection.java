package cn.liuhp.simple.server.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * <p>
 *
 *
 *
 * </p>
 *
 * @author hz16092620
 * @date 2018年9月14日 上午10:57:23
 */
public class RabbitConnection {

    public final static String HOST = "172.20.0.130";//192.168.10.59/10.160.2.62/p版10.145.1.200

    public final static String VIRTUALHOST = "/";

    public final static int PORT = 5672;

    public final static String USERNAME = "it";

    public final static String PASSWORD = "its123";


	public static void main(String[] args) {
		System.out.println(createConnection());
	}
    /**
     * 获取connection
     */
    public static Connection createConnection() {
        Connection conn = null;
        //创建connection工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPort(PORT);
        factory.setVirtualHost(VIRTUALHOST);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
        //通过uri的方式,有错误搞不定
	/*try {
	    //URI uri = new URI("amqp", USERNAME + ":" + PASSWORD, HOST, PORT, VIRTUALHOST, "", "");
	    URI uri = new URI("amqp://" + USERNAME + ":" + PASSWORD + "@" + HOST + ":" + PORT + VIRTUALHOST);
	    factory.setUri(uri);
	} catch (URISyntaxException e1) {
	    e1.printStackTrace();
	} catch (KeyManagementException e) {
	    e.printStackTrace();
	} catch (NoSuchAlgorithmException e) {
	    e.printStackTrace();
	}*/
        try {
            conn = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
 