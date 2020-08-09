import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hz
 * @Description: 通过线程池去多个执行任务
 * @create 2020-01-08
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建固定的5个线程 池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <10 ; i++) {
            //创建任务
            TaskDemo taskDemo = new TaskDemo();
            //将任务放到线程池去执行
            executorService.execute(taskDemo);
        }
        executorService.shutdown();

    }
}
