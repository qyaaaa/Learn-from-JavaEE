package javase高级.sep4;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicTest {
    //图片的加密
    @Test
    public void test1(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("secret.png"));
            fileOutputStream = new FileOutputStream(new File("hk2.png"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                //字节数组进行修改
                for (int i = 0;i < len;i++){
                    buffer[i] = (byte)(buffer[i] ^ 5);
                }

                fileOutputStream.write(buffer,0,len);
            }
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
}
