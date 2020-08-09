package luban;

import java.util.concurrent.TimeUnit;

/**
 * @author hz
 * @Description: 读写线程
 * @create 2019-12-11
 */
public class ReadAndUpdateThread{
    static volatile  int index = 1;
    static final int MAX = 10;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue= index;
            System.out.println("reader");
                while (index < MAX) {
                    if (localValue!=index ) {
                        System.out.println("当前读取数字:" + index);
                        localValue=index;
                    }
                }
        },"read").start();

        new Thread(() -> {
                while (index < MAX) {
                    if (index < MAX) {
                        System.out.println("修改数字:"+(++index));
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
        },"write").start();
    }

}
