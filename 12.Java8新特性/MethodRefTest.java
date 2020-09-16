package javase高级.sep15;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 方法引用的使用：
 * 1.使用情景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用，也是函数式接口的实例
 *
 * 3.使用格式：类（或对象） :: 方法名
 *
 * 4.具体分为如下的三种情况：
 *      情况1：对象 :: 非静态方法
 *      情况2：类 :: 静态方法
 *
 *      情况3：类 :: 非静态方法
 *
 * 5.方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同（针对情况1和情况2）
 */
public class MethodRefTest {

    //情况1： 对象 :: 非静态方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);

        con1.accept("北京");

        System.out.println("***********");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps :: println;
        con2.accept("北京1");
    }

    //情况2：类 :: 静态方法
    //Comparator中的int compare（T t1，T t2）
    //Integer中的int compare（T t1，T t2）
    @Test
    public void test2(){
        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(com1.compare(12, 21));

        System.out.println("*****************");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(21, 12));
    }

    //情况3：类 :: 非静态方法
    //Comparator中的int compare（T t1，T t2）
    //String中的int t1.compareTo(t2)
    @Test
    public void test3(){
        Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abe"));

        System.out.println("************");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abd", "ace"));

    }
}
