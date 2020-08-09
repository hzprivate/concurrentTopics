
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author hz
 * @Description: 通过 CyclicBarrier类去并发执行线程 返回统一结果  与CountDownLatch类似
 * @create 2019-12-21
 */
public class CyclicBarrierDemoDemo {
    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(8);
        Thread[] play = new Thread[8];
        for (int i = 0; i < play.length; i++) {
            play[i] = new Thread(() -> {
                try {
//                    TimeUnit.SECONDS.sleep(new Random().nextInt(7));
                    System.out.println(Thread.currentThread().getName() + "准备好了");

                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + "开始起跑");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "play[" + i + "]");
            play[i].start();
        }
    }
}
