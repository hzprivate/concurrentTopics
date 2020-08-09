import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author hz
 * @Description: 非阻塞式集合
 * @create 2020-01-05
 */
public class CollectionDemo {
    public static void main(String[] args) throws InterruptedException {
//        List<String> list  =  new ArrayList<>();
        ConcurrentLinkedDeque list = new ConcurrentLinkedDeque();
        Thread[] threads = new Thread[100];
        for (int i = 0; i <threads.length ; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j <10000 ; j++) {
                    list.add(Thread.currentThread().getName());
                }
            });
            threads[i].start();
            threads[i].join();
        }
        System.out.println("after add "+list.size());
        Thread[] threadss = new Thread[100];
        for (int i = 0; i <threadss.length ; i++) {
            threadss[i] = new Thread(()->{
                for (int j = 0; j <10000 ; j++) {
                    list.pollLast();
                }
            });
            threadss[i].start();
            threadss[i].join();
        }
        System.out.println("after  remove "+list.size());
    }
}
