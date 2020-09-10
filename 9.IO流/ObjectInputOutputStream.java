package javase高级.sep4;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用：
 * 1.ObjectInputStream和ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型或对象的处理流。
 *        他的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来
 *
 * 3.要想一个java对象是可序列化的，需要满足相应的要求，详细见Person.java
 * 4.序列号机制：
 * 对象序列化机制允许把内存中的java对象转换为平台无关的二进制流，从而允许把这种二进制流持久的保存在磁盘上，或通过网络将这种二进制
 * 流传输到另一个网络节点。其他程序获取了这种二进制流，就可以恢复成原来的java对象
 */
public class ObjectInputOutputStream {
    /*
    序列化的过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void test1(){
        ObjectOutputStream objectOutputStream = null;
        try {
            //1.造流、造对象
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //2.写入或读取
            objectOutputStream.writeObject(new String("我爱中国"));
            objectOutputStream.flush();//刷新操作

            objectOutputStream.writeObject(new Person("张洁华",25));
            objectOutputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (objectOutputStream != null){
                try {
                    //3.关闭流
                    objectOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream实现
     */
    @Test
    public void test2(){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));

            Object object = objectInputStream.readObject();
            String str = (String)object;

            Person p = (Person) objectInputStream.readObject();

            System.out.println(str);
            System.out.println(p);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
