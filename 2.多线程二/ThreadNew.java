package com.javase高级.august24;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。   JDK5.0新增
 *
 * 如何理解实现Callable接口的方式创建多线程的方式比是实现Runnable接口创建多线程方式强大
 * 1.call（）可以有返回值
 * 2.call（）可以抛出异常
 */
public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);


        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start（）方法
        Thread thread1 = new Thread(futureTask);
        thread1.start();

        try {
            //6.获取Callable中call方法中的返回值
            //get（）返回值即为FutureTask构造器参数Callable实现重写的call（）返回值。
            Object sum = futureTask.get();
            System.out.println(" 总和为：" + sum);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

//1.创建一个实现Callable的实现类
class NumThread implements Callable{
    //2.实现call方法，将此线程需要执行的操作声明在call（）中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
