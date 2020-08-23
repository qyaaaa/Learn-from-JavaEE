package com.javase高级.august23;

/**
 * 多线程的创建，方式一：继承于Threadlei
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run（）  将此线程执行的的操作声明在run（）中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start（）
 *
 * 例子：遍历100以内所有的偶数
 */
public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread myThread = new MyThread();

        //4.通过此对象调用start（）  ①启动当前线程 ②调用当前线程的run（）
        myThread.start();

        //不能通过myThread.run（）的方式启动线程

        //再启动一个线程
        MyThread myThread1 = new MyThread();
        myThread1.start();

        //如下操作仍然是在main（）线程中执行的
        for (int i = 0;i < 100 ;i++){
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":"+"hello");
            }
        }
    }
}
//  1.创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2.重写Thread类的run（）
    @Override
    public void run() {
        for (int i = 0;i < 100 ;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}