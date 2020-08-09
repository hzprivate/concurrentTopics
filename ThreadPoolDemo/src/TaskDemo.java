import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author hz
 * @Description:创建任务
 * @create 2020-01-08
 */
public class TaskDemo implements  Runnable {
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" is running");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
