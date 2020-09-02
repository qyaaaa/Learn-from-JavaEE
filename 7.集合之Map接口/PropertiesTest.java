package javase高级.sep1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();
        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        pros.load(fileInputStream);//加载流对应的文件

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name=" + name  + ",password=" + password );
    }
}
