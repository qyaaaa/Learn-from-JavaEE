package javase高级.sep15;

import javase高级.sep3.exer.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用：
 *      和方法引用类型，函数式接口的抽象方法的形参列表和构造器的形参列表一致.
 *      抽象方法的返回值类型即为构造器所属的类的类型
 *
 * 二、数组引用：
 *      可以把数组看作一个特殊的类，则写法与构造器引用一致
 */
public class ConstructorTest {
    //构造器引用
    //Supplier中的T get()
    //Employee的空参构造器：Employee（）
    @Test
    public void test1(){
        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());

        System.out.println("******************");

        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }

    //数组引用
    //Function中的R apply（T t）
    @Test
    public void test2(){
        Function<Integer,String[]> fun1 = length -> new String[length];

        String[] apply = fun1.apply(5);
        System.out.println(Arrays.toString(apply));

        System.out.println("***********************");

        Function<Integer,String[]> fun2 = String[] :: new;
        String[] apply1 = fun2.apply(6);
        System.out.println(Arrays.toString(apply1));
    }
}
