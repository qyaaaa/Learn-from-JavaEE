package com.javase高级.august24;

/**
 * 例题：银行有一个账户。有两个储户分别向同一个账户存3000元，每次存1000，存3次，每次存完打印账户余额
 *
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);

        customer1.setName("客户一");
        customer2.setName("客户二");

        customer1.start();
        customer2.start();
    }
}

class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amt)  {
        if (balance >= 0){
            balance += amt;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
        }
    }
}

class Customer extends Thread{
    private Account account;

    public  Customer (Account account){
        this.account = account;
    }


    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}