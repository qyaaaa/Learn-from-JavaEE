package com.javase高级.august24;

/**
 * 线程通信的应用：经典例题，生产者/消费者问题
 */
public class ProductTest {
    public static void main(String[] args) {

        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");

        Customer1 c1 = new Customer1(clerk);
        c1.setName("消费者1");

        Customer1 c2 = new Customer1(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }
}

class Clerk{
    private int productCount = 0;

    //生产产品
    public synchronized void productProduct(){
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount+"个");

            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //消费产品
    public synchronized void consumerProduct(){
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount+"个");
            productCount--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{//生产者
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始生产" );
        while (true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productProduct();

        }

    }
}

class Customer1 extends Thread{//消费者
    private Clerk clerk;
    public Customer1(Clerk clerk){
        this.clerk = clerk;
        }

    @Override
    public void run() {
        while (true){
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumerProduct();
        }
    }
}
