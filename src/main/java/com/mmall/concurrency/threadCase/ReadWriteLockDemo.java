package com.mmall.concurrency.threadCase;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author rongjianrong
 * @date 2018-12-29
 */
public class ReadWriteLockDemo {

    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock readRock = reentrantReadWriteLock.readLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException{
        try{
            lock.lock(); //模拟读操作
            Thread.sleep(1000);  //读操作的耗时多，读写锁的优势就越明显
            return value;
        }finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock,int index) throws InterruptedException{
        try{
            lock.lock();  //模拟写操作
            Thread.sleep(1000);
            value=index;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnale = new Runnable() {
            @Override
            public void run() {
                try {
//                    demo.handleRead(readRock);
                    demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnale = new Runnable() {
            @Override
            public void run() {
                try {
//                    demo.handleWrite(writeLock,new Random().nextInt());
                    demo.handleWrite(lock,new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for(int i = 0;i < 18;i++){
            new Thread(readRunnale).start();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(writeRunnale).start();
        }
    }
}
