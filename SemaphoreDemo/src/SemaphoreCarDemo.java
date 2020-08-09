import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author hz
 * @Description: 通过信号量去控制max线程数执行  模拟停车场
 * @create 2020-01-05
 */
public class SemaphoreCarDemo {
    public static void main(String[] args) {
        //创建信号量同时最多5个线程执行
        Semaphore semaphore = new Semaphore(5);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
               //获取执行许可
                try {
                    TimeUnit.SECONDS.sleep(2);
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"进了停车场");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                   int val = new Random().nextInt(7);
                    TimeUnit.SECONDS.sleep(val);
                    System.out.println(Thread.currentThread().getName()+"停了"+val+"秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //释放许可
                semaphore.release();
                System.out.println(Thread.currentThread().getName()+"离开停车场");

            },"car["+i+"]");
            threads[i].start();
        }

    }
}
