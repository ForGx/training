import java.util.ArrayList;
import java.util.List;

public class untils {
    //判断字符串是否为数字
    public static boolean isNum(String str){
        try {
            Integer.parseInt(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    //判断字符是否为数字
    public static boolean isNum(char c){
        try {
          Integer.parseInt(String.valueOf(c));
          return true;
        }catch (Exception e){
            return false;
        }
    }
    //排列组合
    public static <T> void array (List<T> list,List<List<T>> lists, Integer size){
//        List<List<T>> lists=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            T t=list.get(0);
            list.remove(0);
            if(list.size()!=1) {
                array(list,lists,size);
            }
            list.add(t);
//            System.out.println(list);
            if (list.size()==size) {
                System.out.println(list);
                lists.add(list);
                System.out.println(lists);
            }
        }
    }
}
