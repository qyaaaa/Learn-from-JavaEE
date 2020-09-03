package javase高级.sep3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 * 1.关于自定义泛型类、泛型接口
 */
public class GenericTest1 {

    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则为Object类型
        //要求：如果定义了带泛型的，建议在实例化时需要指明类的泛型
        Order<String> o1 = new Order<>();
        Order<String> o2 = new Order<>("aa",1001,"cc");
        o1.setOrderT("a");
    }

    @Test
    public void test2(){
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(1001);

        SubOrder1<String> sub = new SubOrder1<>();
        sub.setOrderT("order2......");
    }

    @Test
    public void test3(){
        //泛型不同的引用不能相互赋值
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;

    }

    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] integer = new Integer[]{1,2,3};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copy(integer);
        System.out.println(list);
    }
}
