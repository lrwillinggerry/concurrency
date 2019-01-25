package com.mmall.concurrency.designPatterns;

/**
 * @author rongjianrong
 * @date 2019-01-24
 */
public class StaticSingleton {
    private StaticSingleton(){
        System.out.println("StaticSingleton is create");
    }
    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }
    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
