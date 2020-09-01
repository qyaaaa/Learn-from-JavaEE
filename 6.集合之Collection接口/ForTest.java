package javase高级.august30;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * JDK5.0新增foreach循环，用于遍历集合和数组
 */
public class ForTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("aim",20));
        coll.add(new String("tom"));
        coll.add(false);

        //for(集合中元素的类型 局部变量 ： 集合对象)
        //内部仍然调用了迭代器
        for (Object obj:coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,5,6};
        //for(数组元素的类型 局部变量 ： 数组对象)
        for (int i: arr){
            System.out.println(i);
        }
    }
}
