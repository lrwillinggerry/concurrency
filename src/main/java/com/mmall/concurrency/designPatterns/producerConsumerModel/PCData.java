package com.mmall.concurrency.designPatterns.producerConsumerModel;

/**
 * 任务相关的数据
 * @author rongjianrong
 * @date 2019-01-24
 */
public final class PCData {
    private final int intData;
    public PCData(int d){
        intData = d;
    }
    public PCData(String d){
        intData=Integer.valueOf(d);
    }
    public int getData(){
        return intData;
    }

    @Override
    public String toString() {
        return "data:"+intData;
    }
}
