package cn.liuhp.simple.server.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: java服务端的socket
 * @author: hz16092620
 * @create: 2019-01-15 13:12
 */
public class ServerSocketCustome {

    public static void main(String[] args) {
        createServerSocket();
    }

    /**
    * @Description: 创建服务端socket
    * @param
    * @return
    * @throws
    * @author hz16092620
    * @date 2019/1/15 13:36
    */
    private static void createServerSocket() {
        System.out.println("socket server start !");
        //创建服务socket
        ServerSocket serverSocket = null;
        try {
            //创建服务socket
            serverSocket = new ServerSocket(8080);
            int count = 1;
            while (true) {
                //等待请求，阻塞的
                Socket clientSocket = serverSocket.accept();
                //接受数据
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String line = reader.readLine();
                System.out.println("received from cilent : " + line);
                //响应数据
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                writer.write("come from server data!" + count);
                writer.flush();
                //关闭资源
                reader.close();
                writer.close();
                clientSocket.close();

                count ++;
                if (count > 10) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
            }
        }
        System.out.println("socket server end !");
    }
}
