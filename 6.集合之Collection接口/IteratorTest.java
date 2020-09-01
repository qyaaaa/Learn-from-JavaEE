package javase高级.august30;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法hashNext（）和next（）
 * 2.集合对象每次调用iterator（）方法都得到一个全新的迭代器对象，
 *   默认游标都在集合的第一个对象之前
 *
 * 3.内部定义了remove（）。可以在遍历的时候，删除集合中的元素，此方法不同于集合直接调用remove（）
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("aim",20));
        coll.add(new String("tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        /*
        //方法1：
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        */
        //方法2：不推荐
//        for (int i = 0; i < coll.size();i++){
//            System.out.println(iterator.next());
//        }

        //方法3：推荐
        //hashNext（）：判断是否还有下一个元素
        while (iterator.hasNext()){
            //next（）：①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }

    }

    //测试Iterator中的remove（）
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("aim",20));
        coll.add(new String("tom"));
        coll.add(false);

        //删除集合中的tom
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if ("tom".equals(obj)){
                iterator.remove();
            }
        }

        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
