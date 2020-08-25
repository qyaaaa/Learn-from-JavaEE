package com.javase高级.august24;

/**
 * 例子：创建三个窗口卖票，总票数100张,使用继承Thread类的方式
 *
 * 使用同步代码块的方式解决继承Thread类的方式的线程安全问题
 *
 *  补充：在继承Thread类创建多线程的方式中，我们要慎用this充当同步监视器，可以考虑（Windows.class）类当同步监视器
 */
public class WindowTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.setName("窗口一");
        window2.setName("窗口二");
        window3.setName("窗口三");

        window1.start();
        window2.start();
        window3.start();

    }
}

class Window extends Thread{

    private static int ticket = 100;
    private static Object object = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (Window.class) {//object  (Window.class只会加载一次)
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
