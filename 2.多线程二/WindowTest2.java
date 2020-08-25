package com.javase高级.august24;

/**
 * 例子：创建三个窗口卖票，总票数100张,使用实现Runnable接口的方式
 * 使用同步方法解决实现Runnable接口的线程安全问题
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 window2 = new Window2();
        Thread thread1 = new Thread(window2);
        Thread thread2 = new Thread(window2);
        Thread thread3 = new Thread(window2);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class Window2 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
             show();
        }
    }

    private synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}