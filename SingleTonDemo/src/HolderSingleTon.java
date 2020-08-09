/**
 * 静态内部类 单例
 * @author hz
 * @Description:
 * @create 2019-12-18
 */
public class HolderSingleTon {
    private static  HolderSingleTon holderSingleTon=null;
    private HolderSingleTon(){

    }
    private  static  class GetHolderSingleTon{
        public static  HolderSingleTon getInstance(){
            if(holderSingleTon!=null){
                return holderSingleTon;
            }
            return holderSingleTon = new HolderSingleTon();
        }
    }

    private  HolderSingleTon getHolder(){
        return GetHolderSingleTon.getInstance();

    }

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(  HolderSingleTon.GetHolderSingleTon.getInstance());
        },"thread0").start();

        new Thread(()->{
            System.out.println(  HolderSingleTon.GetHolderSingleTon.getInstance());
        },"thread1").start();

    }

}
