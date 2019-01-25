package com.mmall.concurrency.designPatterns.producerConsumerModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author rongjianrong
 * @date 2019-01-25
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //建立缓冲区
        BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>(10);
        Producer producer1 = new Producer(queue);                                 //建立生产者
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer cusumer1 = new Consumer(queue);                                  //建立消费者
        Consumer cusumer2 = new Consumer(queue);
        Consumer cusumer3 = new Consumer(queue);
        ExecutorService service = Executors.newCachedThreadPool();               //建立线程池
        service.execute(producer1);                                              //运行生产者
        service.execute(producer2);
        service.execute(producer3);
        service.execute(cusumer1);                                               //运行消费者
        service.execute(cusumer2);
        service.execute(cusumer3);
        Thread.sleep(10 * 1000);
    }
}
