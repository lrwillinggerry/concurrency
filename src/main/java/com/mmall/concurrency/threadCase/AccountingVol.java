package com.mmall.concurrency.threadCase;

/**
 * @author rongjianrong
 * @date 2018-12-28
 */
public class AccountingVol implements Runnable{

    static AccountingVol instance = new AccountingVol();
    static int i = 0;
    public synchronized void increase(){
        i++;
    }

    @Override
    public void run() {
        for(int j = 0;j < 10000000;j++){
            increase();
//            synchronized (instance){
//                i++;
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
