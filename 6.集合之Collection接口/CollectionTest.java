package javase高级.august30;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称JAVA容器
 *      说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储
 *
 * 2.1：数组在存储多个数据方面的特点：
 *      ①一旦初始化以后，其长度就确定了
 *      ②数组一旦定义好，其元素的类型也就确定了。我们也只能操作指定类型的数据了
 *      比如String[] arr; Object[] arr1
 * 2.2：数组在存储多个数据方面的缺点：
 *      ①一旦初始化以后，其长度就不可修改。
 *      ②数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高
 *      ③获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      ④数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足
 *
 * 二、集合框架
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据 -->“动态”数组
 *              |----ArrayList、LinkedList、Vector
 *          |----Set接口：存储无序的、不可重复的数据 -->高中讲的“集合”
 *              |----HahSet、LinkedHashSet、TreeSet
 *      |----Map接口：双列集合，用来存储一对（key - value）一对的数据 -->高中函数：y =f（x）
 *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 * 三、Collection接口中方法的使用：
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        //1.add(Object e)：将元素e添加到集合coll中
        coll.add("AA");
        coll.add("bb");
        coll.add("123");//自动装箱
        coll.add(new Date());

        //2.size（）：获取添加的元素的个数
        System.out.println(coll.size());

        //3.addAll（Collection coll1）：将coll1集合中的元素添加到当前集合中
        Collection coll1 = new ArrayList();//4
        coll1.add("456");
        coll1.add("cc");
        coll.addAll(coll1);

        System.out.println(coll.size());//6
        System.out.println(coll);

        //4.clear():清空集合元素
        //coll.clear();

        //5.isEmpty（）:判断当前集合是否为空
        System.out.println(coll.isEmpty());

    }

    /**
     * 结论:
     * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals（）
     */
    @Test
    public void test2(){
        Collection coll = new ArrayList() ;
        coll.add("123");
        coll.add(new String("tom"));
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jem",20));

        //6.contains(Object obj):判断当前集合中是否包含obj
        //我们在判断时会调用obj对象所在类的equals（）。
        boolean contains = coll.contains("123");
        System.out.println(contains);//true
        boolean tom = coll.contains(new String("tom"));
        System.out.println(tom);//true


        //7.containsAll（Collection coll1）：判断形参coll1中的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));

    }

    @Test
    public void test3( ){
        //8.remove(Object obj):从当前集合中移除obj元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("aim",20));
        coll.add(new String("tom"));
        coll.add(false);

        coll.remove(123);
        System.out.println(coll);

        //9.removeAll（Collection coll1）：从当前集合中移除coll1中所有的元素
        Collection coll1 = Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test4( ){
        //10.retains(Collection call1):交集：获取当前集合和coll集合的交集，并返回给当前集合
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("aim",20));
        coll.add(new String("tom"));
        coll.add(false);

        Collection coll1 = Arrays.asList(123,4567);
        coll.retainAll(coll1);
        System.out.println(coll);


    }

    @Test
    public void test5(){
        //11.equals（Object obj）：要想返回true需要当前集合和形参集合元素都相同
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("aim",20));
        coll.add(new String("tom"));
        coll.add(false);

        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("aim",20));
        coll1.add(new String("tom"));
        coll1.add(false);

        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test6(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("aim",20));
        coll.add(new String("tom"));
        coll.add(false);

        //12.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());//-1257406011

        //13.集合 -->数组:toArray()
        Object[] objects = coll.toArray();
        for (int i = 0;i < objects.length;i++){
            System.out.println(objects[i]);
        }

        //拓展：数组 -->集合:调用Arrays类的静态方法asList（）
        List<String> strings = Arrays.asList(new String[]{"aa", "bb", "cc"});
        System.out.println(strings);

        //14.iterator（）：返回Iterator接口的实例，用于遍历集合元素，放在IteratorTest.java中测试

    }
}
