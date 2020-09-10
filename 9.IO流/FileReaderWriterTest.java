package javase高级.sep4;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构：
 *   抽象基类        节点流（文件流）                                 缓冲流（处理流的一种）
 * 1.InputStream    FileInputStream(read([byte] cbut))            BufferedInputStream(read([byte] cbut))
 * 2.OutputStream   FileOutputStream(write(byte[] cbut,0,len))    BufferedOutputStream(write(byte[] cbut,0,len))
 * 3.Reader         FileReader(read([char] cbut))                 BufferedReader(read([char] cbut))/readline()
 * 4.Writer         FileWriter(write(char[] cbut,0,len))          BufferedWriter(write(char[] cbut,0,len))/flush()
 */
public class FileReaderWriterTest {

    /*
    说明：
    1.read()的理解：返回读入的一个字符，如果到达文件末尾返回-1
    2.异常的处理；为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally来使用
    3.读入的文件一定要存在，否则会报错
     */
    @Test
    public void test1() {
        FileReader fileReader = null;
         try {
             //1.实例化File类的的对象，指明要操作的文件
             File file1 = new File("helloworld");
             //System.out.println(file1.getAbsolutePath());

             //2.提供具体的流
             fileReader = new FileReader(file1);

             //3.数据的读入
             //read()返回读入的一个字符。如果到达文件末尾返回-1
             int data;
             while ((data = fileReader.read()) != -1) {
                 System.out.print((char) data);
             }}catch(IOException e){
                 e.printStackTrace();
             }finally{
                 //4.流的关闭操作
                 try {
                     if (fileReader != null) {
                         fileReader.close();
                     } }catch (IOException e) {
                     e.printStackTrace();
                 }
             }
    }

    //对read（）操作升级，使用read的重载方法
    @Test
    public void test2() throws IOException {
        FileReader fileReader= null;
        try {
            //1.File类的实例化
            File file = new File("helloworld");
            //2.FileReader流的实例化
            fileReader = new FileReader(file);
            //3.读入的操作
            //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数，如果达到文件末尾返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fileReader.read(cbuf)) != -1){
                //方法1
                //for (int i = 0;i < len;i++ ){
                  //  System.out.print(cbuf[i]);
                //}

                //方法2
                String s = new String(cbuf,0, len);
                System.out.print(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4.资源的关闭
            try {
                fileReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    //从内存中写出数据到硬盘里
    /*说明：
    1.输出操作：对应的File可以不存在的。并不会报异常
    2.File对应的硬盘中文件如果不存在，在输出的过程中，会自动创建此文件
      File对应的硬盘中文件如果存在：
                            如果流使用的构造器是：FileWriter（file，false）/FileWriter（file）对原有文件进行覆盖
                            如果流使用的构造器是：FileWriter（file，true）不会对原有文件进行覆盖，而是在原有文件基础上继续添加
     */
    @Test
    public void test3() throws IOException {
        //1.File类的实例化
        File file = new File("hello");

        //2.提供FileWriter的对象用于数据的写出
        FileWriter fileWriter = new FileWriter(file,true);

        //3.写出的操作
        fileWriter.write("zjh");
        fileWriter.write("shab");

        //4.流资源的关闭操作
        fileWriter.close();
    }

    @Test
    public void test4(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File file = new File("hello");
            File file1 = new File("hello2");

            //2.创建输入流和输出流的对象
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file1);

            //3.数据的读入和写出操作
            char[] cbuf = new char[6];
            int len;
            while ((len = fileReader.read(cbuf)) != -1){
                //每次写出len个字符
                fileWriter.write(cbuf,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4.关闭流资源
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try {
                if (fileWriter != null){
                    fileWriter.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

}

