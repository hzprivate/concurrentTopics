import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author hz
 * @Description: 阻塞集合操作
 *  如果方法不能被立即执行 put() take（） 则该方法线程会进入等待，直到方法执行完
 *  如果方法不能被立即执行 add() remove()  element() 抛出异常
 *  如果方法不能被立即执行 offer() poll()  超时
 * @create 2021-02-02
 */
public class LinkedBlockingDequeDemo {
    public static void main(String[] args) {

        LinkedBlockingDeque deque = new LinkedBlockingDeque(50);
        Thread[] threads = new Thread[100];
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(()-> {
                try {
                    deque.put(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"thread"+i);
            threads[i].start();
        }


        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end"+ Arrays.stream(deque.toArray()).collect(Collectors.toList()));


        for (int i = 0; i < threads.length; i++) {
            threads[i] =  new Thread(()-> {
                System.out.println(deque.peek());
            },"thread"+i);
            threads[i].start();
        }


    }
}
