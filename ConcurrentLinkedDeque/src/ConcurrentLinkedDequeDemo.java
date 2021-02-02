import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author hz
 * @Description: 非阻塞集合操作  试验能否 控制顺序一致性
 * 如果方法不能被立即执行，则会返回null或抛出异常，使用该方法的线程不会被阻塞
 * @create 2021-02-02
 */
public class ConcurrentLinkedDequeDemo {
    public static void main(String[] args) {

        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
        Thread[] threads = new Thread[100];
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(()-> {
                deque.add(Thread.currentThread().getName());
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
                System.out.println(deque.poll());
            },"thread"+i);
            threads[i].start();
        }


    }
}
