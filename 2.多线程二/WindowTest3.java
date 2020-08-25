package com.javase高级.august24;

/**
 * 例子：创建三个窗口卖票，总票数100张,使用继承Thread类的方式
 * 使用同步方法解决继承Thread类的线程安全问题
 */
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 window1 = new Window3();
        Window3 window2 = new Window3();
        Window3 window3 = new Window3();

        window1.setName("窗口一");
        window2.setName("窗口二");
        window3.setName("窗口三");

        window1.start();
        window2.start();
        window3.start();

    }
}

class Window3 extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while (true){

            show();
        }
    }

    private static synchronized void show(){//同步监视器w1，w2，w3
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