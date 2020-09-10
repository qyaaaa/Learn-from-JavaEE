package javase高级.sep8;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * url网络编程
 * 1.URL：统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 * http://localhost:8080/abcd/hk.png？username=Tom
 * 协议    主机名     端口号   资源地址     参数列表
 */
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/abcd/hk.png？username=Tom");
        url.getProtocol();//协议名
        url.getHost();//主机名
        url.getPort();//端口号
        url.getPath();//文件路径
        url.getFile();//文件名
        url.getQuery();//获取该URL的查询名

    }
}
