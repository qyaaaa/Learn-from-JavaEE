package javase高级.sep4;

import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：1.对于文本文件使用字符流处理（.txt,.c,.java,.cpp）
 *      2.对于非文本文件，使用字节流处理(.jpg,.mp3,.mp4,.avi,.doc,.ppt........)
 *
 */
public class FileInputOutputStream {


    //使用字节流来处理文本文件可能出现乱码
    @Test
    public void test1(){
        FileInputStream fileInputStream = null;
        try {
            //1.造文件
            File file = new File("hello");

            //2.造流
            fileInputStream = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[6];
            int len;//记录每次读取字节的个数
            while ((len = fileInputStream.read(buffer)) != -1){
                String string = new String(buffer,0,len);
                System.out.println(string);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                //4.关闭资源
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    //实现对图片的复制操作
    @Test
    public void test2()  {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File("hk.png");
            File file1 = new File("hk1.png");

            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
            System.out.println("复制成功");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (fileOutputStream != null){

                    fileOutputStream.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }

    //指定路径下文件的复制
    public void copy(String srcPath,String destPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(srcPath);
            File file1 = new File(destPath);

            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
            System.out.println("复制成功");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (fileOutputStream != null){

                    fileOutputStream.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4(){
        long start = System.currentTimeMillis();

        copy("hk.png","hk3.png");

        long end = System.currentTimeMillis();
        System.out.println("复制所花费的时间为" + (end - start));//93
    }
}
