package JavaSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.130.115",9999);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("helloWorld".getBytes());
            while (true){

            }

        } catch (IOException e) {
            System.out.println("socket创建失败");
        }
    }
}
