package com.mmall.concurrency.threadCase;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rongjianrong
 * @date 2018-12-29
 */
public class FairLock implements Runnable {
    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while(true){
            try{
                fairLock.lock();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1,"Thread_t1");
        Thread t2 = new Thread(r1,"Thread_t2");
        t1.start();
        t2.start();
    }
}
