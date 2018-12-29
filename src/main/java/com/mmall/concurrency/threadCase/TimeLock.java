package com.mmall.concurrency.threadCase;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rongjianrong
 * @date 2018-12-28
 */
public class TimeLock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if(lock.tryLock(5, TimeUnit.SECONDS)){
                Thread.sleep(4000);
            }else{
                System.out.println("get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock ti1 = new TimeLock();
        Thread t1 = new Thread(ti1);
        Thread t2 = new Thread(ti1);
        t1.start();
        t2.start();
    }
}
