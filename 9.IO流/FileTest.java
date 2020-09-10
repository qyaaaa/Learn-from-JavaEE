package javase高级.sep4;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * File类的使用：
 * 1.File类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
 * 2.File类声明在java.io包下
 *
 * 3.File中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法方
 *   并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成
 *
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的终点
 * String getAbsolutePath():获取绝对路径
 * String getPath():获取路径
 * String getName():获取名称
 * String getParent():获取上层文件目录路径。若无，返回null
 * long length():获取文件长度（字节数）。不能获取目录的长度
 * long lastModified():获取最后一次的修改时间，毫秒值
 * 如下的两个方法适用于文件目录:
 * String[] list():获取指定目录下的所有文件或者文件目录下的名称数组
 * File[] listFiles():获取指定目录下的所有文件或者文件目录的File数组
 */
public class FileTest {

    /*
    1.如何创建File类的实例
        File(String filePath)
        File(String parentPath,String childPath)
        File(File parentFile,String childPath)

    2.相对路径:相对于某个路径下，指明的路径
      绝对路径:包含盘符在内的文件或文件目录的路径

    3.路径分隔符：
    window：\\
    unix:/
     */
    @Test
    public void test1(){
        //构造器1：
        File file = new File("hello.txt");//相对于当前module
        File file1 = new File("D:\\abc\\hello.txt");
        File file2 = new File("d:" + File.separator + "abc" + File.separator + "hello.txt");

        System.out.println(file);
        System.out.println(file1);

        //构造器2：
        File file3 = new File("D:\\abc","bcd");
        System.out.println(file3);

        //构造器3：
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("C:\\Users\\qiao\\Desktop\\java\\javase\\idea快捷公式.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    @Test
    public void test3(){
        File file = new File("e:\\study_demo");
        String[] list = file.list();
        for (String s:list){
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for (File f:files){
            System.out.println(f);
        }
    }

    //public boolean renameTo(File dest):把文件重命名为指定的文件路径
        //比如：file1.renameTo(file2)为例：
    //要想保证成功file1在硬盘中要存在，file2在硬盘中不存在

    @Test
    public void test4(){
        File file1 = new File("E:\\study_demo\\src\\javase高级\\sep4\\hello.txt");
        File file2 = new File("E:\\study_demo\\hi.txt");

        boolean b = file1.renameTo(file2);
        System.out.println(b);
        file2.renameTo(file1);
    }

    /*
    File类的判断功能：
    boolean isDirectory():判断是否是文件目录
    boolean isFile():判断是否是文件夹
    boolean exists():判断是否存在
    boolean canRead():判断是否可读
    boolean canWrite():判断是否可写
    boolean isHidden():判断是否隐藏
     */
    @Test
    public void test5(){
        File file1 = new File("hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        File file2 = new File("e:\\study_demo");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }

    /*
    File类的创建功能：创建硬盘中对应的文件或文件目录
    boolean createNewFile():创建文件。二若文件存在，则不创建，返回false
    boolean mkdir():创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层不存在，也不创建
    boolean mkdirs():创建文件目录。如果上层文件目录不存在，一并创建
    File类的删除功能：删除磁盘中的文件或文件目录：
    boolean delete():删除文件或者文件夹
    删除注意事项：
    java中的删除不走回收站
     */
    @Test
    public void test6() throws IOException {
        //文件的创建
        File file1 = new File("hi.txt");
        if (!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else {//文件存在
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test7(){
        //文件目录的创建
        File file1 = new File("e:\\study_demo\\123");
        boolean mkdir = file1.mkdir();
        if (mkdir){
            System.out.println("创建成功");
        }
        //要想删除成功目录下不能有子目录或文件（file.delete）



    }
}
