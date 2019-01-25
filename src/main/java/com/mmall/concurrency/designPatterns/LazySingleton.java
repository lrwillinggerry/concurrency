package com.mmall.concurrency.designPatterns;

/**
 * @author rongjianrong
 * @date 2019-01-24
 */
public class LazySingleton {
    private LazySingleton(){
        System.out.println("LazySingleton is create");
    }
    private  static LazySingleton instance = null;
    public static synchronized  LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
