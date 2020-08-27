package javase高级.august26;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 */
public class StringTest1 {
    /*
    复习：
    String与基本数据类型、包装类之间的转换。
    String --》基本数据类型、包装类
    基本数据类型、包装类 --》String
     */
    @Test
    public void test1(){
        String str1 = "123";
        int i = Integer.parseInt(str1);
        System.out.println(i);

        String str3 = i + "";
        System.out.println(str3);

        System.out.println(str1 == str3);//false

        boolean b1 = true;
        String str2 = String.valueOf(b1);
        System.out.println(str2);
    }

    /**
     * String 与 char[]之间的转换
     * String --> char[]:调用SString的toCharArray（）
     * char[] --> String:调用String的构造器
     */
    @Test
    public void test2(){
        String str1 = "abc123";
        char[] chars = str1.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            System.out.println(chars[i]);

        }

        char[] chars1 = new char[]{'h','e','l','l','o'};
        String s = new String(chars1);
        System.out.println(s);
    }

    /**
     * String 与 byte[]之间的转换
     * 编码：String --> byte[]:调用String的getBytes（）
     * 解码：byte[] --> String:调用String的构造器
     * 编码：字符串 --》字节 （看得懂 --》二进制数据）
     * 解码：编码的逆过程，字节 --》字符串（二进制数据 --》看得懂）
     *
     * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1 = str1.getBytes("gbk");
        System.out.println(Arrays.toString(bytes1));

        String s = new String(bytes);
        System.out.println(s);//使用默认的字符集，进行解码

        String gbk = new String(bytes1, "gbk");
        System.out.println(gbk);

    }
}
