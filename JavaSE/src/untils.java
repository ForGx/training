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
    //排列
    public static <T> void array (List<T> list,List<List<T>> lists,Integer index){
        int x=index;
        for (;index<list.size();index++){
            List<T> listCopy=new ArrayList<>(list);
            T t=listCopy.get(x);
            listCopy.set(x,list.get(index));
            listCopy.set(index,t);
            array(listCopy,lists,x+1);
            if (x==(list.size()-1)) {
                lists.add(listCopy);
            } else {
                listCopy.clear();
            }
        }
    }
}
