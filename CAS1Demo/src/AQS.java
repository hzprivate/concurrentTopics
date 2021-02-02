import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hz
 * @Description:实现AQS轻量级锁
 * @create 2019-12-21
 */
public class AQS {
    Lock lock = new ReentrantLock();
    private int count = 0;

    public void addCoount() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] t = new Thread[20];
        AQS aqs = new AQS();

        for (int i = 0; i < 20; i++) {
            t[i] = new Thread(() -> {
                aqs.addCoount();
                System.out.println(aqs.count);
            });
            t[i].start();
        }

    }
}
