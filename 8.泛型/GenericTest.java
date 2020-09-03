package javase高级.sep3;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用：
 * 1.JDK5.0新增特性
 *
 * 2.在集合中使用泛型：
 * 总结：①集合接口或集合类在jdk5.0时都修改为带泛型的结构
 *      ②在实例化集合类时，可以指明具体的泛型类型
 *      ③指明完以后，在集合类或接口中凡是定义类或接口时，内部结构使用到类的泛型的位置，都指定为实例化的泛型类型
 *          比如：（add E e） -->实例化以后add(Integer e)
 *      ④泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型时，转化为包装类
 *      ⑤如果实例化时，没有指明泛型的类型，默认为Object类型
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 * 4.注意：异常类不能说泛型的
 *
 * 5.泛型在继承方面的体现：
 * 虽然类A是类B的父类，但是G<E>和G<B>不具备子父类关系，二者是并列关系,二者的共同父类是<?>
 * 补充：类A是类B是的父类，A<G> B<G>具备子父类的关系
 * 6.通配符的使用:<?>
 *     对于list<?>就不能向其内部添加数据，除了添加null之外
 *     允许读取数据，读取的数据类型为Object
 *
 * 7.有限制条件的通配符的使用：
 *      ？extends A: (<=)
 *      G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类
 *      ？super A: (>=)
 *      G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类类
 */
public class GenericTest {

    //在集合中使用泛型之前的情况：
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(50);
        list.add(60);
        list.add(100);
        //问题1：类型不安全
        list.add("tom");
        for (Object score:list){
            //问题2：强转时，可能出现异常
            //int stuScore = (int)score;
            System.out.println(score);
        }
    }

    //在集合中使用泛型的情况，以ArrayList为例
    @Test
    public void test2(){
        //编译时就会进行类型检查，保证数据的安全
        ArrayList<Integer> list = new ArrayList<Integer>();
         list.add(78);
         list.add(50);
         list.add(60);
         list.add(100);
         for (Integer score:list){
             //避免了强转操作
             int stuScore = score;
             System.out.println(stuScore);
         }

        Iterator<Integer> iterator = list.iterator();
         while (iterator.hasNext()){
             System.out.println(iterator.next());
         }
    }

    //在集合中使用泛型的情况，以HashMap为例
    @Test
    public void test3(){
        //Map<String,Integer> map = new HashMap<String, Integer>();
        //jdk7的新特性，类型推断
        Map<String,Integer> map = new HashMap<>();
        map.put("tom",12);
        map.put("jack",52);
        map.put("ma",82);
        map.put("jerry",92);

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "-->" + value);
        }

    }

    //泛型在继承方面的体现
    @Test
    public void test4(){
        Object object = null;
        String str = null;

        object = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1 和list2不具有子父类关系
        //list1 = list2

        List<String> list3 = null;
        ArrayList<String> list4 = null;
        list3 = list4;
    }

    //通配符的使用
    @Test
    public void test5(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;

        show(list1);
        show(list2);
    }

    public void show(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test6(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
        //list1 = list5;

        //list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据
        list1 = list3;
        Person person = list1.get(0);
        //Student student = list1.get(0);
        //编译不通过

        //写入数据
        //编译不通过
        //list1.add(new Student());

        //编译通过
        list2.add(new Student());
        list2.add(new Person());
    }
}
