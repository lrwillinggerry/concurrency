package com.mmall.concurrency.designPatterns;

/**
 * @author rongjianrong
 * @date 2019-01-24
 */
public class Singleton {

    private Singleton(){
        System.out.println("Singleton is create");
    }
    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
}
