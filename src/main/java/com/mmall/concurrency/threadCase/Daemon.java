package com.mmall.concurrency.threadCase;

/**
 * @author rongjianrong
 * @date 2018-12-28
 */
public class Daemon {

    public static class DaemonT extends Thread {
        @Override
        public void run() {
            while(true){
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new DaemonT();
        t.setDaemon(true);
        t.start();

        Thread.sleep(2000);
    }

}
