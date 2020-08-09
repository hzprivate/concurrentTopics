/**
 * @author hz
 * @Description:秒杀程序
 * @create 2019-12-26
 */
public class MiaoShaDemo {
    private static volatile int count = 3;

    public synchronized static String deleteCount() {
        //双重锁检测
        if(count>0){
            count--;
            return "SUCCESS";
        }
       return "FAIL";
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[1200];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                //如果本地空间和内存中count不一致
                if (count > 0) {
                    String s = deleteCount();
                    if("SUCCESS".equals(s)){
                        System.out.println(Thread.currentThread().getName() + "抢到票");
                    }
                    else{
                        System.out.println(Thread.currentThread().getName() + "该票已售罄");
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "该票已售罄");
                }

            }, "用户" + i);

            threads[i].start();
        }


    }
}
