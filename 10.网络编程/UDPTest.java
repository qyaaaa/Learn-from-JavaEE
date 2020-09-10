package javase高级.sep8;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP的网络编程
 */
public class UDPTest {
    //发送端
    @Test
    public void test1() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String str = "UDP方式发送";
        byte[] data = str.getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket datagramPacket = new DatagramPacket(data,0,data.length,localHost,9090);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();

    }
    //接收端
    @Test
    public void test2() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9090);
        byte[] buffer = new byte[100];

        DatagramPacket datagramPacket = new DatagramPacket(buffer,0,buffer.length);
        datagramSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(),datagramPacket.getLength()));

        datagramSocket.close();
    }
}
