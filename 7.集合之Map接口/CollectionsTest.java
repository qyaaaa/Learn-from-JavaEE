package javase高级.sep1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Collections：操作Collection、Map的工具类
 * 方法：
 * reverse(List):反转list中元素的顺序
 * shuffle(List):对list集合元素进行随机排序
 * sort(List):根据元素的自然顺序对指定list集合元素按升序排序
 * sort(list,Comparator):根据指定的Comparator产生的顺序对list集合元素进行排序
 * swap(List int,int):将指定list集合中的i处元素和j处元素进行交换
 *
 * Object max(Collection):根据元素的自然排序，返回给定集合中的最大元素
 * Object max(Collection,Comparator):根据Comparator指定的顺序，返回给定集合中的最大元素
 * Object min(Collection):根据元素的自然排序，返回给定集合中的最小元素
 * Object min(Collection,Comparator);根据Comparator指定的顺序，返回给定集合中的最小元素
 * int frequency(Collection,Object):返回指定集合中指定元素的出现次数
 * void copy(List dest,List src):将src中的内容复制到dest中
 * boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换list
 *
 *
 */
public class CollectionsTest {

    /**
     * Collections类中提供了多个synchronizedXxx（）方法，该方法
     * 可使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集
     * 合时的线程安全问题
     */
    
    @Test
    public void test3(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-10);
        list.add(0);

        //返回的list1即为线程安全的
        List list1 = Collections.synchronizedList(list);
    }

    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-10);
        list.add(0);

        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-10);
        list.add(0);

        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);
    }


}
