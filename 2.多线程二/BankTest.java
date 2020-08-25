package com.javase高级.august24;

/**
 * 单例模式之饿汉式：
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 */
public class BankTest {
}

class Bank{
    private Bank(){}
    private static Bank instance = null;

    public static Bank getInstance(){
        //同步方法
    //public static synchronized Bank getInstance(){
        //同步代码块
       //方法一 ，效率差

        /*synchronized (Bank.class) {
            if(instance == null){
                instance = new Bank();
            }
            return instance;
        }*/

        //方法二,效率更高

        if(instance == null) {
            synchronized (Bank.class) {
                if(instance == null) {
                    instance = new Bank();
                }
            }

        }
        return instance;
    }
}
