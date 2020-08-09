import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hz
 * @Description:
 * @create 2020-01-05
 */
public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("hz");
        list.add("is");
        list.add("human");
        //可以在遍历是新增
//        for (int i = 0; i <list.size(); i++) {
//            if(i==1){
//                list.add("sd");
//            }
//        }

        //不可以
//        for (String s : list) {
//            if("is".equals(s)){
//                list.add("shdj");
//            }
//        }

        //不可以
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            if("is".equals(next)){
                list.remove("is");
            }
        }
        list.forEach(System.out::println);
    }

}
