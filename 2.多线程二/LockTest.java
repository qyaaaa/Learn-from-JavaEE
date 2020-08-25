package com.javase高级.august24;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁   （JDK5.0新增）
 *
 * 1.面试题：synchronized与Lock的异同？
 *  相同：两者都可以解决线程安全问题
 *  不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *       Lock需要手动的启动同步（lock（）），同时结束也需要手动的实现（unlock（））
 */
public class LockTest {
    public static void main(String[] args) {
        Window4 window = new Window4();
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class Window4 implements Runnable{
    private int ticket = 100;
    //1.
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
           try {
               //2.调用锁定方法：lock（）
               lock.lock();
               if (ticket > 0){
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName() + ":售票，票号为" + ticket);
                   ticket--;
               }else {
                   break;
               }
           }finally {
               //3.调用解锁方法unlock（）
               lock.unlock();

           }
        }

    }
}
