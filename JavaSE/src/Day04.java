import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day04 {
    public static void main(String[] args) {
//        questionOne();
//        questionTwo();
//        questionThree();
//        questionFour();
        questionFive();
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.remove(0);
//        list.add(1);
//        System.out.println(list);
//        List<List<Integer>> lists = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        untils.array(list,lists,list.size());
//        System.out.println(lists);
    }

    /**
     * 输入某年某月某日，判断这一天是这一年的第几天？
     */
    private static void questionOne(){
        int days=0;
        int[] monthDays={31,28,31,30,31,30,31,31,30,31,30,31};
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入年月日：");
        String dataStr=scanner.next();
        char[] dataChar=dataStr.toCharArray();
        String[] dataStrs={"","",""};
        for (int i=0,j=0;i<dataChar.length;i++){
            if (untils.isNum(dataChar[i])){
                dataStrs[j]+=String.valueOf(dataChar[i]);
            }else {
                j++;
            }
        }
        for (int i=1;i<Integer.parseInt(dataStrs[1]);i++){
            days+=monthDays[i];
        }
        days+=Integer.parseInt(dataStrs[2]);
        boolean isLeap=Integer.parseInt(dataStrs[0])%4==0;
        if (isLeap&&Integer.parseInt(dataStrs[1])>2){
            days+=1;
        }
        System.out.println("这一天是这一年的第"+days+"天");
    }

    /**
     * 输入三个整数x,y,z，请把这三个数由小到大输出
     */
    private static void questionTwo(){
        Scanner scanner=new Scanner(System.in);
        List<Integer> nums=new ArrayList<>();
        String numStr;
        while (true) {
            System.out.println("请输入整数(输入非整数结束)：");
            numStr=scanner.next();
            if (!untils.isNum(numStr)){
                break;
            }
            nums.add(Integer.parseInt(numStr));
        }
        int min;
        for (int m=0; m < nums.size();m++){
            min=nums.get(m);
            for (int n = m;n<nums.size();n++){
                if (min>nums.get(n)){
                    min=nums.get(n);
                    nums.set(n,nums.get(m));
                    nums.set(m,min);
                }
            }
        }
        for (Integer x:nums){
            System.out.println(x);
        }
    }

    /**
     * 输出9*9口诀
     */
    private static void questionThree(){
        for (int i=1;i<=9;i++){
            for (int j=1;j<=i;j++){
                if (i*j<10) {
                    System.out.print(i + "*" + j + "=" + (i * j) + "  ");
                }else {
                    System.out.print(i + "*" + j + "=" + (i * j) + " ");
                }
            }
            System.out.println("");
        }
    }

    /**
     * 猴子吃桃问题：
     * 猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个。
     * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
     * 以后每天早上都吃了前一天剩下的一半零一个。
     * 到第10天早上想再吃时，见只剩下一个桃子了。
     * 求第一天共摘了多少
     */
    private static void questionFour(){
        int peachs=1;
        for (int i=1;i<10;i++){
            peachs=(peachs+1)*2;
        }
        System.out.println("第一天共摘了"+peachs+"个桃子");
    }

    /**
     * 两个乒乓球队进行比赛，各出三人。
     * 甲队为a,b,c三人，乙队为x,y,z三人。
     * 已抽签决定比赛名单。
     * 有人向队员打听比赛的名单。
     * a说他不和x比，c说他不和x,z比，
     * 请编程序找出三队赛手的名单。
     *
     * 除了题目本身还扩展实现了，总共可以出现多少种组合
     */
    private static void questionFive(){
        String[] a={"a","b","c"};
        String[] b={"x","y","z"};
        List<List<String>> nameList=new ArrayList<>();
        for (int o=0;o<3;o++) {
            for (int i = 0; i < 3; i++) {
                List<String> list=new ArrayList<>();
                if (i==o){
                    continue;
                }
                list.add(a[i]+b[0]);
                list.add(a[o]+b[1]);
                list.add(a[3-i-o]+b[2]);
                nameList.add(list);
            }
        }
        System.out.println(nameList.toString());
        for (List<String> playerList:nameList){
            for (int i=0;i<playerList.size();i++){
                if (playerList.get(i).equals("ax")||playerList.get(i).equals("cx")||playerList.get(i).equals("cz")){
                    break;
                }
                if ( i== (playerList.size()-1) ){
                    System.out.println("比赛名单为：");
                    System.out.println(playerList.toString());
                }
            }
        }
    }
}
