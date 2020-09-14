package javase高级.sep11.exer;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 */
public class ReflectionTest {

    @Test
    public void test1() throws Exception{//（）不需要掌握
        Class<Person1> clazz = Person1.class;

        //创建运行时类的对象
        Person1 p = clazz.newInstance();

        //获取指定的属性:要求运行时类中属性声明为public
        //所以通常不使用此方法
        Field id = clazz.getField("id");

        //设置当前属性的值
        //set（）：参数1：指明设置哪个对象的属性  参数2：将此属性设置为多少
        id.set(p,1001);

        /*
        获取当前属性的值
        get（）：参数1：获取哪个对象的当前属性值
         */
        int pId = (int)id.get(p);
        System.out.println(pId);
    }

    //如何操作运行时类中指定的属性（需要掌握）
    @Test
    public void test2() throws Exception{
        Class<Person1> clazz = Person1.class;

        //创建运行时类的对象
        Person1 p = clazz.newInstance();

        //1.getDeclaredField(String name):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //2.setAccessible（true）：保证当前属性是可访问的
        name.setAccessible(true);
        //3.获取、设置指定对象的此属性值
        name.set(p,"Tom");
        System.out.println(name.get(p));
    }

    //如何操作运行时类中指定的方法（需要掌握）
    @Test
    public void test3() throws Exception{
        Class<Person1> clazz = Person1.class;

        //创建运行时类的对象
        Person1 p = clazz.newInstance();

        //1.获取指定的某个方法
        //getDeclaredMethod():参数1：指明获取的方法的名称 参数2：指明获取方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);

        //2.保证当前方法是可访问的
        show.setAccessible(true);

        //3.调用invoke（）方法执行           invoke():参数1：方法的调用者 参数2：给方法形参赋值的实参
        //invoke()方法的返回值即为对应类中调用的方法的返回值
        Object chn = show.invoke(p, "CHN");//我的国籍是CHN
        System.out.println(chn);//CHN

        System.out.println("******如何调用静态方法********");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，则invoke（）返回null
        Object invoke = showDesc.invoke(Person1.class);
        System.out.println(invoke);//null
    }

    /*
    调用运行时类中指定的构造器(不需要掌握)
     */
    @Test
    public void test4() throws Exception{
        Class<Person1> clazz = Person1.class;

        //private Person1(String name)
        //1.获取指定的构造器     getDeclaredConstructor():参数：指明构造器的参数列表
        Constructor<Person1> constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        constructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person1 tom = constructor.newInstance("Tom");
        System.out.println(tom);
    }
}
