/**
 * @author hz
 * @Description:饿汉式单例
 * @create 2019-12-18
 */
public class HungrySingleTon {
    private static HungrySingleTon hungrySingleTon = new HungrySingleTon();
    private HungrySingleTon(){

    }
    public static HungrySingleTon getInstance(){
        return hungrySingleTon;
    }

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            System.out.println(getInstance());
        }

    }

}
