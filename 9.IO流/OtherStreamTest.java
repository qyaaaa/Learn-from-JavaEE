package javase高级.sep4;

import org.junit.Test;

import java.io.*;

/**
 * 其他流的使用
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流
 */
public class OtherStreamTest {
    /*
    1.标准的输入、输出流
    1.1
    System.in：标准的输入流，默认从键盘输入
    System.out：标准的输出流，默认从控制台输出
    1.2
    System类的setIn（InputStream）/setOut（PrintStream）方式重新指定输入和输出的流
    1.3练习：
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。
    然后继续进行输入操作，直至当输入“e”或“exit”时，退出程序

    //方法1：使用Scanner实现，调用next（）返回字符串
    //方法2：使用System.in实现。System.in ---> 转换流 --->BufferedReader的readline（）
     */
    @Test
    public void test1(){
        BufferedReader bufferedReader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);
            while (true){
                System.out.println("请输入字符串：");
                String data = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
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
        }

    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);
            while (true){
                System.out.println("请输入字符串：");
                String data = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
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
        }
    }

    /*
    2.打印流：PrintStream和PrintWriter
    2.1提供了一系列重载的print（）和println（）
    2.2练习：
     */
    @Test
    public void test2(){
        PrintStream printStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(""));
            printStream = new PrintStream(fileOutputStream, true);
            if (printStream != null){
                System.out.println(printStream);
            }

            for (int i = 0; i <= 255;i++){
                System.out.print((char) i);
                if (i % 50 == 0){
                    System.out.println();
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            if (printStream != null){
                    printStream.close();
            }
        }
    }

    /*
    3.数据流
    3.1DataInputStream和DataOutputStream
    3.2作用：用于读取或写出基本数据类型的变量或字符串

    练习：将内存中的字符串，基本数据类型的变量写出到文件中
    处理异常仍然使用try-catch-finally
     */
    @Test
    public void test3() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.txt"));
        dataOutputStream.writeUTF("张洁华");
        dataOutputStream.flush();//刷新的操作
        dataOutputStream.writeInt(25);
        dataOutputStream.flush();
        dataOutputStream.writeBoolean(false);
        dataOutputStream.flush();

        dataOutputStream.close();

    }

    /*
    将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中
    注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致
     */
    @Test
    public void test4() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("data.txt"));

        String name = dataInputStream.readUTF();
        int age = dataInputStream.readInt();
        boolean ismale = dataInputStream.readBoolean();

        System.out.println("name= " + name );
        System.out.println("age= " + age );
        System.out.println("ismale= " + ismale );

        if (dataInputStream != null){
            dataInputStream.close();
        }




    }

}
