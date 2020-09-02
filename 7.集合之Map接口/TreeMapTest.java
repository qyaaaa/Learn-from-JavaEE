package javase高级.sep1;

import org.junit.Test;

import java.util.*;

public class TreeMapTest {
    //向TreeMap中添加key-value，要求key必须是同一个类创建的对象
    //因为要按照key进行排序：自然排序、定制排序
    @Test
    public void test1(){
        //按年龄排序
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(),p2.getAge());

                }
                throw new RuntimeException("数据类型不一致");
            }
        });
        Person u1 = new Person("tom", 20);
        Person u2 = new Person("jack", 18);
        Person u3 = new Person("jerry", 8);
        Person u4 = new Person("rose", 23);

        map.put(u1,90);
        map.put(u2,60);
        map.put(u3,88);
        map.put(u4,100);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            Map.Entry entry = (Map.Entry) object;
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}
