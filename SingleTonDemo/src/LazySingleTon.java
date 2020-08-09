/**
 * @author hz
 * @Description:懒汉式单例
 * @create 2019-12-18
 */
public class LazySingleTon {
    private static LazySingleTon lazySingleTon=null;
    private LazySingleTon(){

    }
    public static LazySingleTon getInstance(){
        if(lazySingleTon!=null){
            return lazySingleTon;
        }
        return  lazySingleTon = new LazySingleTon();
    }

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            System.out.println(LazySingleTon.getInstance());
        }

    }

}
