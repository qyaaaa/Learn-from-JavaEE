package javase高级.august26;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 *
 * 对比String、StringBuffer、StringBuilder三者的效率：
 * 从高到低排列：StringBuilder > StringBuffer > String
 */
public class StringBufferBuilderTest {
    /**
     * String,StringBuffer,StringBuilder三者的异同
     * String：不可变的字符序列：底层使用char[]存储
     * StringBuffer：可变的字符序列：线程安全的，效率低：底层使用char[]存储
     * StringBuilder：可变的字符序列：JDK5.0新增，线程不安全的，效率高：底层使用char[]存储
     *
     * 源码分析：
     * String s = new String（）；//char[] value = new char【0】
     * String s2 = new String（"abc"）;//char[] value = new char[]{'a','b','c'}
     *
     * StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建于一个长度是16的char数组
     * sb1.append('a');//value[0] = 'a';
     * sb1.append('b');//value[1] = 'b';
     * StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length() + 16];
     * 问题1:sb2.length //3
     * 问题2：扩容问题：如果要添加的数据底层数组盛不下了。那就需要扩容底层的数组。
     *      默认情况下，扩容为原来容量的2倍 + 2，同时将原有数组中的元素复制到新的数组中
     *      指导意义：开发中建议大家使用：StringBuffer（int capacity）或StringBuilder（int capacity）
     */
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);//mbc
    }

    /**
     * StringBuffer的常用方法
     * StringBuffer append(xxx):提供了很多的append（）方法，用于字符串拼接
     * StringBuffer delete(int start,int end):删除指定位置的内容
     * StringBuffer replace(int start,int end,String str):把【start，end)位置替换为str
     * StringBuffer insert(int offset,xxx):在指定位置插入xxx
     * StringBuffer reverse():把当前字符序列逆转
     * public int indexOf(String str)
     * public String substring(int start,int end):返回一个从start开始到end索引结束的左闭右开区间的子子字符串
     * public int length()
     * public char charAt(int n)
     * public void setCharAt(int n,char ch)
     *
     *      总结：增：append(xxx)
     *           删：delete(int start,int end)
     *           改：setCharAt(int n,char ch) / replace(int start,int end,String str)
     *           查：charAt(int n)
     *           插：insert(int offset,xxx)
     *           长度：length()
     *           遍历：for() + charAt() / toString()
     */
    @Test
    public void test2(){
        StringBuffer stringBuffer1 = new StringBuffer("abc");
        stringBuffer1.append(1);
        stringBuffer1.append('1');
        System.out.println(stringBuffer1);//abc11
        stringBuffer1.delete(2,4);
        System.out.println(stringBuffer1);//ab1

        StringBuffer stringBuffer2 = new StringBuffer("abc");
        stringBuffer2.replace(2,4,"hello");
        System.out.println(stringBuffer2);//abhello

        StringBuffer stringBuffer3 = new StringBuffer("abc");
        stringBuffer3.insert(2,false);
        System.out.println(stringBuffer3);//abfalsec

        stringBuffer3.reverse();
        System.out.println(stringBuffer3);//ceslafba

    }

}
