package javase高级.sep11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 */
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("麻辣烫");

        System.out.println("**********************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory pro = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        pro.produceCloth();



    }
}

interface Human{
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human{
    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

/*
要想实现动态代理，需要解决的问题？
问题1：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
问题2：当通过代理类的对象调用方法时，如何动态的区调用被代理类中的同名方法
 */
class ProxyFactory{
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){//obj：被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的方法，调用方法a时，就会自动的调用如下的方法：invoke（）
    //将被代理类要执行的方法a的功能声明在invoke（）中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();

        //method():即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj：被代理类的对象
        Object returnValue = method.invoke(obj, args);

        humanUtil.method2();

        //上述方法的返回值就作为当前类中的invoke（）的返回值
        return returnValue;
    }
}

class HumanUtil{
    public void method1(){
        System.out.println("=========通用方法1=======");
    }

    public void method2(){
        System.out.println("=========通用方法2=========");
    }
}