import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author hz
 * @Description: APP--->三个线程到不同的公司查询--》result
 * 1、CountdownLatch（查询航班）
 * @create 2019-12-21
 */
public class CountDownLanchDemo {
    static List<String> companyList = Arrays.asList("南京航空公司", "北京航空公司", "上海航空公司");
    static List<String> resultList = new ArrayList<String>();

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(companyList.size());
        Thread[] threads = new Thread[companyList.size()];
        String origin = "BS";
        String dest = "HS";
        for (int i = 0; i < threads.length; i++) {
            String name = companyList.get(i);
            threads[i] = new Thread(() -> {
                try {
                    System.out.printf("%s 查询从%s到%s的机票\n", name, origin, dest);
                    int count = new Random().nextInt(10);
                    System.out.println("count:" + count);
                    TimeUnit.SECONDS.sleep(count);
                    resultList.add(name + "剩余" + count + "张票");
                    System.out.printf("%s 查询成功\n", name);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        countDownLatch.await();

        System.out.println(resultList.size());
        resultList.forEach(System.out::println);


    }
}
