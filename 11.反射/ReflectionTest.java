package javase高级.sep11;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    //反射之前，对Person类的操作
    @Test
    public void test1(){
        //1.创建Person类的对象
        Person person = new Person("Tom",12);

        //2.通过对象,调取其内部的属性和方法
        person.age = 10;
        System.out.println(person.toString());

        person.show();

        //3.在Person类的外部，不可以通过Person类的对象调用其内部的私有结构
    }

    //反射之后，对Person类的操作
    @Test
    public void test2() throws Exception{
        Class<Person> personClass = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person p = constructor.newInstance("Tom", 12);
        System.out.println(p.toString());
        
        //2.通过反射调用对象指定的属性、方法
        //2.1调属性
        Field age = personClass.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        //2.2调方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(p);
        
        //通过反射调用，可以调用Person类的私有结构的。比如私有的构造器、属性、方法
        //调用私有的构造器
        Constructor<Person> cons1 = personClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = cons1.newInstance("Jerry");
        System.out.println(p1.toString());

        //调用私有的属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"zhangjiehua");
        System.out.println(p1.toString());

        //调用私有的方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);
    }

    /*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序在经过javac.exe命令以后会生成一个或多个字节码文件(.class)结尾，接着我们使用java.exe命令对某个字节码文件进行解释运行。
    将某个字节码文件加载到内存中，此过程称为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个实例。
    2.换句话说：Class的实例就对应着一个运行时类
    3.加载到内存的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类
     */
    //获取Class实例的方式
    //前三个掌握，最后一个了解
    @Test
    public void test3() throws Exception{
        //方式一：调用运行时类的属性
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("javase高级.sep11.Person");
        System.out.println(clazz3);

        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("javase高级.sep11.Person");
        System.out.println(clazz4);
 }

    //Class实例可以是哪些结构的说明
    @Test
    public void test4(){
        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class<String[]> c3 = String[].class;
        Class<int[][]> c4 = int[][].class;
        Class<ElementType> c5 = ElementType.class;
        Class<Override> c6 = Override.class;
        Class<Integer> c7 = int.class;
        Class<Void> c8 = void.class;
        Class<Class> c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class<? extends int[]> c10 = a.getClass();
        Class<? extends int[]> c11 = b.getClass();
        //只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

}
