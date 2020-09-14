package javase高级.sep11.exer;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {
    /*
    获取构造器结构
     */
    @Test
    public void test1(){
        Class<Person1> clazz = Person1.class;
        //getConstructors():获取当前运行时类声明为public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor c:constructors){
            System.out.println(c);
        }

        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c: declaredConstructors){
            System.out.println(c);
        }
    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test2(){
        Class<Person1> clazz = Person1.class;
        Class<? super Person1> superclass = clazz.getSuperclass();
        System.out.println(superclass);

        //获得带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /*
    获取运行时类的带泛型的父类的泛型
     */
    @Test
    public void test3(){
        Class<Person1> clazz = Person1.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType par = (ParameterizedType)genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = par.getActualTypeArguments();

        System.out.println(actualTypeArguments[0].getTypeName());//方法1
        System.out.println(((Class)actualTypeArguments[0]).getName());//方法2
    }

    /*
    获取运行时类实现的接口
     */
    @Test
    public void test4(){
        Class<Person1> clazz = Person1.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class c:interfaces){
            System.out.println(c);
        }

        System.out.println();

        //获取运行时类的父类实现的接口
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c: interfaces1){
            System.out.println(c);
        }
    }

    /*
    获取运行时类所在的包
     */
    @Test
    public void test5(){
        Class<Person1> clazz = Person1.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);

    }

    /*
    获取运行时类所声明的注解
     */
    @Test
    public void test6(){
        Class<Person1> clazz = Person1.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a: annotations){
            System.out.println(a);
        }
    }
}
