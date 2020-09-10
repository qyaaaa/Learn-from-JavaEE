package javase高级.sep4;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用：
 * 1.转换流：属于字符流
 *      InputStreamReader：将一个字节的输入流转换为字符的输入流
 *      OutputStreamWriter：将一个字符的输出流转化为字节的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.解码：字节、字节数组 --->字符数组、字符串
 *   编码：字符数组、字符串 --->字节、字节数组
 *
 * 4.字符集
 */
public class InputStreamReaderTest {

    //InputStreamReader的使用：将字节的输入流转换为字符的输入流
    @Test
    public void test1(){
        InputStreamReader inputStreamReader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("hello");
            //参数2指明了字符集，具体使用哪个字符集，取决于文件保存时使用的字符集
            inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");//使用系统默认的字符集

            char[] cbuf = new char[5];
            int len;
            while ((len = inputStreamReader.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (inputStreamReader != null){
                    inputStreamReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    //综合使用InputStreamReader和OutputStreamWriter
    @Test
    public void test2(){
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            //1.造文件、造流
            File file1 = new File("hello");
            File file2 = new File("hello_gbk");

            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);

            inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"gbk");

            //读写过程
            char[] cbuf = new char[10];
            int len;
            while ((len = inputStreamReader.read(cbuf)) != -1){
                outputStreamWriter.write(cbuf,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //3.关闭流
            try {
                if (inputStreamReader != null){
                    inputStreamReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try {
                if (outputStreamWriter != null){
                    outputStreamWriter.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }





    }
}
