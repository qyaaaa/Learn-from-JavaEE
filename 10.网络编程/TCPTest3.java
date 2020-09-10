package javase高级.sep8;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现tcp的网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地，并返回“发送成功”给客户端。并关闭相应的连接
 */
public class TCPTest3 {
    @Test
    public void test1(){
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream(new File("hk.png"));
            byte[] buffer = new byte[20];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
            }

            //关闭数据的输出
            socket.shutdownOutput();
            //接收来自于服务器端的数据，并显示到控制台上
            InputStream inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[20];
            int len1;
            while ((len1 = inputStream.read(buffer1)) != -1){
                byteArrayOutputStream.write(buffer1,0,len1);
            }
            System.out.println(byteArrayOutputStream.toString());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (outputStream != null){
                try {
                    outputStream.close();
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
            if (byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("beauty2.png"));

        byte[] buffer = new byte[20];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer,0,len);
        }
        System.out.println("图片传输完成");
        //服务端给予客户端反馈
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("已收到".getBytes());

        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        outputStream.close();
    }
}
