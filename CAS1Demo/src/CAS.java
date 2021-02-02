import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hz
 * @Description:实现线程交替性交互  A—>B->A->C->A->D
 * @create 2019-12-21
 */
public class CAS {
    private static  volatile int count=0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static  void addCoount(){
        count++;
    }
    public static void addAtomic(){
        atomicInteger.incrementAndGet();
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] t = new Thread[20];
        for (int i = 0; i <20 ; i++) {
            t[i] = new Thread(()->{
//                addCoount();
                addAtomic();
//                atomicInteger.compareAndSet(1,30);
            });
           t[i].start();
           t[i].join();
        }
        System.out.println(count);
        System.out.println(atomicInteger.get());
    }
}
