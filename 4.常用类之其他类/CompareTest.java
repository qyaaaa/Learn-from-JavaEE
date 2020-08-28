package javase高级.august28;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：java中的对象，正常情况下，只能进行： == 或！=。不能使用 >或 <
 *      但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小
 *      如何实现？使用两个接口中的任何一个：Comparable 或Comparator
 *
 * 二、Comparable接口与Comparator的使用对比：
 *      Comparable接口的方式一旦指定，保证Comparable接口实现类的对象在任何位置都可以比较大小
 *      Comparator接口属于临时性的比较。
 *
 */
public class CompareTest {
    /**
     * Comparable接口的使用举例：   自然排序
     * 1.像String、包装类等实现了Comparable接口，重写了compareTo（obj）方法，给出了比较两个对象大小的方式
     * 2.像String、包装类重写compareTo（obj）方法后，进行了从小到大排序
     * 3.重写compareTo（obj）的规则：
     * 如果当前对象this大于形参对象obj，则返回正整数
     * 如果当前对象this小于形参对象obj，则返回负整数
     * 如果当前对象this等于形参对象obj，则返回零
     * 4.对于自定义类来说，如果需要排序，我们可以让其自定义Comparable接口，重写compareTo（obj），在compareTo（obj）方法中指明如何排序
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","BB","DD","GG"};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("联想",50);
        arr[1] = new Goods("华为",50);
        arr[2] = new Goods("惠普",50);
        arr[3] = new Goods("戴尔",58);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * Comparator接口的使用：定制排序
     * 1.背景：
     * 当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口
     * 的排序规则不适合当前的操作，那么可以考虑使用Comparator的对象来排序
     * 2.重写compareTo（Object o1，Object o2）方法，比较o1和o2的大小
     *  返回正整数：表示o1大于o2
     *  返回负整数：表示o1小于o2
     *  返回零：表示相等
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","BB","DD","GG"};

        Arrays.sort(arr, new Comparator() {
            //按照字符串从大到小排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入数据类型不一致");

            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("联想",50);
        arr[1] = new Goods("华为",50);
        arr[2] = new Goods("惠普",50);
        arr[3] = new Goods("戴尔",58);
        Arrays.sort(arr, new Comparator() {
            //名称从低到高，价格从高到低
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if (g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else {
                        return g1.getName().compareTo(g2.getName());
                    }

                }
                throw new RuntimeException("数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
