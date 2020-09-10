package javase高级.sep8;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例子1：客户端发送内容给服务端，服务端将内容打印到控制台上
 */
public class TCPTest1 {
    //客户端
    @Test
    public void test1(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);
            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据
            os.write("你好，我是客户端".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4.资源的关闭
            if (os != null){
                try {
                    os.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }


    }
    //服务端
    @Test
    public void test2(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2.调用accept（）表示接收来自客户端的Socket
            socket = serverSocket.accept();
            //3.获取输入流
            inputStream = socket.getInputStream();
            //4.读取输入流中的数据
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len;
            while ((len = inputStream.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());
            System.out.println("收到了来自：" + socket.getInetAddress().getHostAddress() + "的数据");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //5.资源的关闭
            if (byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (inputStream != null){
                try {
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (serverSocket  != null){
                try {
                    serverSocket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }



    }
}
