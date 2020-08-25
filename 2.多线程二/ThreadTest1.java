package com.javase高级.august24;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法：run（）
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start（）
 *
 * 比较创建线程的两种方式：
 * 开发中优先选择实现Runnable接口的方式
 * 原因：1.实现的方式没有类的单继承性的局限性
 *      2.实现的方式更适合来处理多个线程有共享数据的情况
 *
 * 联系：都实现了Runnable接口
 * 相同点：两种方式都需要重写run（）方法，将线程要执行的逻辑声明在run（）中
 *
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        // * 3.创建实现类的对象
        MyThread myThread = new MyThread();
        // * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread thread1 = new Thread(myThread);
        // * 5.通过Thread类的对象调用start（） ①启动线程 ②调用当前线程的run（）
        thread1.start();

        Thread thread2 = new Thread(myThread);
        thread2.start();
    }
}

// * 1.创建一个实现了Runnable接口的类
class MyThread implements Runnable{
    // * 2.实现类去实现Runnable中的抽象方法：run（）
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
