package javase高级.sep4;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用：
 * 1.RandomAccessFile直接继承于Java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 * 3.如果randomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建，如果写出到的文件不存在，则会对原有文件进行覆盖（默认情况下，从头覆盖）
 * 4.可以通过相关的操作，实现RandomAccessFile"插入"数据的效果
 */
public class RandomAccessFileTest {

    @Test
    public void test1(){
        RandomAccessFile randomAccessFile = null;
        RandomAccessFile rw = null;
        try {
            randomAccessFile = new RandomAccessFile(new File("hk.png"),"r");
            rw = new RandomAccessFile(new File("hk3.png"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = randomAccessFile.read(buffer)) != -1){
                rw.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (randomAccessFile != null){
                try {
                    randomAccessFile.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (rw != null){
                try {
                    rw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("helloworld"),"rw");
        randomAccessFile.seek(3);//将指针调到角标为3的位置
        randomAccessFile.write("xyz".getBytes());
        randomAccessFile.close();
    }

    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("helloworld"),"rw");
        randomAccessFile.seek(3);//将指针调到角标为三的位置
        //保存指针3后面的所有数据到StringBuilder中

        StringBuilder builder = new StringBuilder((int) new File("helloworld").length());
        byte[] buffer = new byte[1024];
        int len;
        while ((len = randomAccessFile.read(buffer)) != -1){
            builder.append(new String(buffer,0,len));
        }
        //调回指针，写入xyz
        randomAccessFile.seek(3);
        randomAccessFile.write("xyz".getBytes());

        //将StringBuilder中的数据写入到文件中
        randomAccessFile.write(builder.toString().getBytes());

        randomAccessFile.close();
    }
}
