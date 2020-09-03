package javase高级.sep3.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class EmployeeTest {
    //问题1：使用自然排序
    @Test
    public void test1(){
        TreeSet<Employee> set = new TreeSet<>();
        Employee e1 = new Employee("liudehua",58,new MyDate(1960,5,8));
        Employee e2 = new Employee("guofucheng",50,new MyDate(1978,4,8));
        Employee e3 = new Employee("liming",45,new MyDate(1968,3,8));
        Employee e4 = new Employee("huangjiaju",50,new MyDate(1970,2,8));
        Employee e5 = new  Employee("chenglong",68,new MyDate(1950,1,8));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            Employee e = iterator.next();
            System.out.println(e);
        }

    }
    //问题2：按生日排序
    @Test
    public void test2(){
        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate b1 = o1.getBirthday();
                MyDate b2 = o2.getBirthday();
                return b1.compareTo(b2);
            }

            /*@Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee)o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    int minusYear = b1.getYear() - b2.getYear();
                    //比较年
                    if (minusYear != 0){
                        return minusYear;
                    }
                    int minusMonth = b1.getMonth() - b2.getMonth();
                    //比较月
                    if (minusMonth != 0){
                        return minusMonth;
                    }
                    //比较日
                    return b1.getDay() - b2.getDay();
                }
                throw new RuntimeException("传入的数据类型不一致");
            }*/
        });

        Employee e1 = new Employee("liudehua",58,new MyDate(1960,5,8));
        Employee e2 = new Employee("guofucheng",50,new MyDate(1978,4,8));
        Employee e3 = new Employee("liming",45,new MyDate(1968,3,8));
        Employee e4 = new Employee("huangjiaju",50,new MyDate(1970,2,8));
        Employee e5 = new Employee("zhenglong",68,new MyDate(1950,1,8));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
