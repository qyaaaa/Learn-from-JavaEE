package javase高级.sep4;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用：
 *
 * 1.BufferedInputStream
 *   BufferedOutputStream
 *   BufferedReader
 *   BufferedWriter
 *
 * 2.作用：提供流的读取，写入操作
 *
 * 提高读写速度的原因:
 *      内部提供了一个缓冲区
 *
 * 3.处理流，就是套接在已有的流的基础上的流
 *
 * */
public class BufferedTest {

    /**
     * 实现非文本文件的复制
     */
    @Test
    public void test1()  {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            //1.造文件
            File file = new File("hk.png");
            File file1 = new File("hk2.png");
            //2.造流
            //2.1造节点流
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file1);

            //2.2.造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //3.复制到细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if (bufferedInputStream != null){
                    bufferedInputStream.close();

                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try {
                if (bufferedOutputStream != null){
                    bufferedOutputStream.close();

                }
            }catch (IOException e){
                e.printStackTrace();
            }
            //关闭外层流的同时，内层流会自动的关闭
            //fileInputStream.close();
            //fileOutputStream.close()
        }


    }

    public void copy(String srcPath,String descPath){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            //1.造文件
            File file = new File(srcPath);
            File file1 = new File(descPath);
            //2.造流
            //2.1造节点流
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file1);

            //2.2.造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //3.复制到细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);
                //刷新缓冲区
                bufferedOutputStream.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if (bufferedInputStream != null){
                    bufferedInputStream.close();

                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try {
                if (bufferedOutputStream != null){
                    bufferedOutputStream.close();

                }
            }catch (IOException e){
                e.printStackTrace();
            }
            //关闭外层流的同时，内层流会自动的关闭
            //fileInputStream.close();
            //fileOutputStream.close()
        }
    }

    @Test
    public void test4(){
        long start = System.currentTimeMillis();

        copy("hk.png","hk4.png");

        long end = System.currentTimeMillis();
        System.out.println("复制所花费的时间为" + (end - start));//93
    }

    /*
    使用BufferedReader和BufferWriter实现文本文件的复制
     */
    @Test
    public void test5(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("hello")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("hello1")));

            /*
            //方式1
            char[] cbuf = new char[1024];
            int len;
            while ((len = bufferedReader.read(cbuf)) != -1){
                bufferedWriter.write(cbuf,0,len);
            }
             */

            //方式2
            String data;
            while ((data = bufferedReader.readLine()) != null){
                //方法1
                //bufferedWriter.write(data + "\n");//data中不包含换行符
                //方法2
                bufferedWriter.write(data);
                bufferedWriter.newLine();//提供的换行操作
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader != null){
                    bufferedReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try {
                if (bufferedWriter != null){
                    bufferedWriter.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }



    }
}
