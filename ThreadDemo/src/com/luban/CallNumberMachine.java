package com.luban;

import java.util.concurrent.TimeUnit;

/**
 * @author hz
 * @Description:叫号机
 * @create 2019-12-11
 */
public class CallNumberMachine extends Thread {
      static volatile   int index=1;

     static  final  int MAX=500;
    final Object lock = new Object();
    @Override
    public  void run() {
        synchronized (lock){
            while(index<MAX){
//                try {
//                    TimeUnit.SECONDS.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+"当前叫号机："+(++index));
            }
        }
    }

    public static void main(String[] args) {
        CallNumberMachine t1 = new CallNumberMachine();
        CallNumberMachine t2 = new CallNumberMachine();
        CallNumberMachine t3 = new CallNumberMachine();
        CallNumberMachine t4 = new CallNumberMachine();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
