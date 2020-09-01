package javase高级.august30;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 1.向TreeSet中添加的数据，要求是相同类的对象
 * 2.两种排序方式：自然排序 和 定制排序
 *
 * 3.自然排序中，比较两个对象是否相同的标准为：compareTo（）返回0.不再是equals（）方法
 * 4.定制排序中，比较两个对象是否相同的标准为：compareTo（）返回0.不再是equals（）方法
 */
public class TreeSetTest {
    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        //不能添加不同类的对象
        set.add(123);
        set.add(456);
        //set.add("aa");
        //set.add(new Person("tom",20));
        set.add(-10);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        TreeSet set = new TreeSet();
        set.add(new Person("tom",16));
        set.add(new Person("tim",20));
        set.add(new Person("jack",18));
        set.add(new Person("mi",20));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){
        //按照年龄从小到大排列
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person)o1;
                    Person p2 = (Person)o2;
                    return Integer.compare(p1.getAge(),p2.getAge());

                }else {
                    throw new RuntimeException("数据类型不一致");
                }

            }
        };
        TreeSet set = new TreeSet(com);
        set.add(new Person("tom",16));
        set.add(new Person("tim",20));
        set.add(new Person("jack",18));
        set.add(new Person("mi",20));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
