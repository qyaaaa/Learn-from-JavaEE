package javase高级.august26;

import org.junit.Test;

public class StringMethodTest {
    /**
     * 替换：
     * String replace（char oldChar，char newChar）：返回一个新的字符串，他是通过用newChar替换此字符串中出现的所有oldChar得到的
     * String replace（CharSequence target，CharSequence replacement）：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串
     * String replaceAll（String regex，String replacement）：使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串
     * String replaceFirst（String regex，String replacement）：使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串
     * 匹配：
     * boolean matches（String regex）：告知此字符串是否匹配给定的正则表达式
     * 切片：
     * String【】split（String regex）：根据给定的正则表达式匹配拆分此字符串
     * String【】split （String regex，int limit）：更具匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部放到最后一个元素中
     */
    @Test
    public void test3(){
        String str1 = "学习和加瓦";
        String str3 = str1.replace('和','或');

        String str2 = str1.replace("和","或");
        System.out.println(str2);

        String str4 = "123hello456world789";

        //将字符串中的数字替换成”，“，如果开头和结尾有”，“的话去掉
        String string = str4.replaceAll("\\d+",",").replaceFirst("^,|$","");
        System.out.println(string);

        String str = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);//true

        str = "hello|world|java";
        String[] strings = str.split("\\|");
        for(int i = 0; i < strings.length;i++) {
            System.out.println(strings[i]);
        }

        
    }
    /**
     * boolean endsWith(String suffix):测试此字符串是否以指定的后缀结束
     * boolean startsWith（String prefix）：测试此字符是否以指定的前缀开始
     * boolean startsWith（String prefix，int toffset）：测试此字符串从指定索引开始的子字符串是否以指定的前缀开始
     *
     * boolean contains（CharSequence s）：当且仅当此字符串包含指定的char值序列时，返回true
     * int indexOf（String str）：返回指定子字符串在此字符中第一次出现处的索引
     * int indexOf（String str，int fromIndex）：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
     * int lastIndexOf（String str）：返回指定子字符串在此字符中最右边出现处的索引
     * int lastIndexOf（String str，int fromIndex）；返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
     * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
     */
    @Test
    public void test2(){
        String s1 = "hello world";
        boolean b1 = s1.endsWith("ld");
        System.out.println(b1);//true

        boolean b2 = s1.startsWith("he");
        System.out.println(b2);//true

        boolean b3 = s1.startsWith("ll",2);
        System.out.println(b3);//true

        String s2 = "wo";
        System.out.println(s1.contains(s2));//true

        System.out.println(s1.indexOf("lo"));//3

        System.out.println(s1.indexOf("lo",1));

        System.out.println(s1.lastIndexOf("l"));//9

        System.out.println(s1.lastIndexOf("l",5));//3
    }


    /**
     * int length():返回字符串的长度 ：
     * char charAt(int index): 返回某索引处的字符
     * boolean isEmpty（）：判断是否是空字符
     * String toLowerCase（）：使用默认语言环境，将String中的所有字符转换为小写
     * String toUpperCase（）：使用默认语言环境，将String中的所有字符转换为大写
     * String trim（）：返回字符串的副本，忽略前导空白和尾部空白
     * boolean equals（Object obj）：比较字符串的内容是否相同
     * boolean equalsIgnoreCase（String anotherString）：与equals方法类似，忽略大小写
     * String concat（String str）：将指定字符连接到此字符串的结尾。等价于“+”
     * int compareTo(String anotherString):比较两个字符串的大小
     * String substring（int beginIndex）：返回一个新的字符串，它是此字符串的从bgeinIndex开始截取到最后的一个子字符串
     * String substring（int beginIndex，int endIndex）：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex（不包含）的一个子字符串。（左闭右开）
     */
    @Test
    public void test1(){
        String s1 = "helloworld";
        System.out.println(s1.length());//10

        System.out.println(s1.charAt(1));//e

        System.out.println(s1.isEmpty());//false

        System.out.println(s1.toUpperCase());//HELLOWORLD

        String s2 = "     hello world      ";
        System.out.println(s2.trim());//hello world

        String s3 = "HELLoworld";
        System.out.println(s1.equalsIgnoreCase(s3));//true

        String s4 = "def";
        System.out.println(s4.concat("abc"));//defabc

        String s5 = "abc";
        String s6 = "abd";
        System.out.println(s5.compareTo(s6));//-1

        String s7 = "学习和加瓦";
        System.out.println(s7.substring(3));//加瓦

        System.out.println(s7.substring(3,5));
    }


}
