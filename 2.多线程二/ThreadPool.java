package com.javase高级.august24;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：1.提高响应速度（减少创建新线程的时间）
 *      2.降低资源消耗（重复利用线程池中的线程，不需要每次都创建）
 *      3.便于线程管理
 *
 *      corePoolSize：核心池的大小
 *      maximumPoolSize：最大线程数
 *      keepAliveTime：线程没有任务时最多保持多长时间后会终止
 */
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor service1 = (ThreadPoolExecutor) executorService;
        //设置线程池的属性
        service1.setCorePoolSize(10);

        //2.执行指定线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        executorService.execute(new NumberThread());//适合使用于Runnable
        //executorService.submit();//适合使用与Callable

        executorService.execute(new NumberThread1());

        //关闭线程池
        executorService.shutdown();
    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100 ; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }

        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100 ; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }

        }
    }
}