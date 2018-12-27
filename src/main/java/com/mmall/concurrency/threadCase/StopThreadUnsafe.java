package com.mmall.concurrency.threadCase;

/**
 * @author rongjianrong
 * @date 2018-12-15
 */
public class StopThreadUnsafe {

    public static User u = new User();
    public static class User{
        private int id;
        private String name;
        public User(){
            id=0;
            name="0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User [id=" + id + ", name=" + name + "]";
        }
    }
    public static class ChangeObjectThread extends Thread{
        volatile boolean stopme = false;

        public void stopMe(){
            stopme = true;
        }
        @Override
        public void run() {
            while(true){
                if(stopme){
                    System.out.println("exit by stop me");
                    break;
                }
                synchronized (u){
                    int v = (int)(System.currentTimeMillis()/1000);
                    u.setId(v);
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread{
        @Override
        public void run() {
            while(true){
                synchronized (u){
                    if(u.getId() != Integer.parseInt(u.getName())){
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
//        new ReadObjectThread().start();
//        while (true){
//            Thread t = new ChangeObjectThread();
//            t.start();
//            Thread.sleep(150);
//            t.interrupt();
//        }

//        Thread t1 = new Thread(){
//            @Override
//            public void run() {
//                while (true){
//                    if(Thread.currentThread().isInterrupted()){
//                        System.out.println("Interruted!");
//                        break;
//                    }
//                    int v = (int)(System.currentTimeMillis()/1000);
//                    System.out.println(v);
//                    Thread.yield();
//                }
//            }
//        };
//        t1.start();
//        Thread.sleep(2000);
//        t1.interrupt();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                while(true){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interruted!");
                        break;
                    }
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.out.println("Interruted When Sleep");
                        //设置中断状态
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
