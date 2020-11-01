package JavaSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //1.开启服务器
            ServerSocket server = new ServerSocket(9999);
            while (true){
                //2.等待客户端的连接
                Socket accept = server.accept();
                new ServerHandler(accept).start();
            }
        } catch (IOException e) {
            System.out.println("端口占用");
        }
    }
}
