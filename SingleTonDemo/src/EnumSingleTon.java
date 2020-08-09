/**
 * 枚举 内部类 线程安全且懒加载
 * @author hz
 * @Description:
 * @create 2019-12-19
 */
public class EnumSingleTon {
    private  EnumSingleTon(){

    }
    //枚举类
    private  enum EnumDemo{
        INSTANCE;
        private  EnumSingleTon enumSingleTon;
        private  EnumDemo(){
            this.enumSingleTon = new EnumSingleTon();
        }
    }

    public  static EnumSingleTon getInstance(){
        return EnumDemo.INSTANCE.enumSingleTon;
    }

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(  EnumSingleTon.getInstance()+","+EnumSingleTon.getInstance().getClass().getName());
        },"thread0").start();

        new Thread(()->{
            System.out.println(  EnumSingleTon.getInstance()+","+EnumSingleTon.getInstance().getClass().getName());
        },"thread1").start();

    }
}
