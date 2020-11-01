package JavaSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerHandler extends Thread{
    Socket accept;
    public ServerHandler(Socket socket){
        this.accept = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = accept.getInputStream();
            byte []data = new byte[1024];
            int len;
            while ((len= inputStream.read(data))!=-1){
                System.out.println(new String(data,0,len));
            }
        } catch (IOException e) {
            System.out.println("输出流获取失败");
        }
    }
}
