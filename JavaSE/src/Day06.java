import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Day06 {
    public static void main(String[] args) {
//        questionOne();
//        questionTwo();
//        questionThree();
//        questionFour();
//        questionFive();
//        questionSix();
//        questionSeven();
//        questionEight();
        questionNine();
    }

    /**
     * 打印出如下图案（菱形）
     */
    private static void questionOne(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入菱形大小（整数）：");
        Integer size=scanner.nextInt();
        for (int i=0;i<size;i++){
            for (int j=1;j<size;j++){
                if (j>=size-i&&j<=size+i){
                            System.out.print("* ");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
        for (int i=size-2;i>0;i--){
            for (int j=1;j<size;j++){
                if (j>=size-i&&j<=size+i){
                    System.out.print("* ");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }

    /**
     * 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13…求出这个数列的前20项之和
     */
    private static void questionTwo(){
        double molecule=2;
        double denominator=1;
        double sum=0;
        double t;
        for (int i=0;i<20;i++){
            sum+=molecule/denominator;
            t=molecule;
            molecule+=denominator;
            denominator=t;
        }
        System.out.println(sum);
    }

    /**
     * 求1+2!+3!+…+20!的和,递归法求5！
     */
    private static void questionThree(){
        System.out.println(factoringSum(20));
    }
    //递归法求阶乘和
    private static long factoringSum(long num){
        if(num==1){
            return 1;
        }
        return factoring(num)+factoringSum(num-1);
    }
    //递归法求阶乘
    private static long factoring(long num){
        if (num==1){
            return 1;
        }
        return num*factoring(num-1);
    }

    /**
     * 有5个人坐在一起，
     * 问第5个人多少岁？他说比第4个人大2岁。
     * 问第4个人岁数，他说比第3个人大2岁。
     * 问第3个人，又说比第2人大两岁。
     * 问第2个人，说比第一个人大两岁。
     * 最后问第一个人，他说是10岁。
     * 请问第五个人多大？
     */
    private static void questionFour(){
        System.out.println(age(5));
    }
    private static int age(int age){
        if(age==1){
            return 10;
        }
        return age(age-1)+2;
    }

    /**
     * 给一个不多于5位的正整数，
     * 要求：一、求它是几位数，二、逆序打印出各位数字。
     */
    private static void questionFive(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("请输入一个不多于5位的正整数：");
        try {
            int num=scanner.nextInt();
            if(num<0){
                System.out.println("您输入数字不是正数!");
                return;
            }
            String numStr=String.valueOf(num);
            char[] chars=numStr.toCharArray();
            if(chars.length>5){
                System.out.println("您输入数字超过5位!");
                return;
            }
            System.out.println("这是"+chars.length+"位数");
            for (int i=chars.length-1;i>=0;i--){
                System.out.println("第"+i+"位是"+chars[i]);
            }
        }catch (Exception e){
            System.out.println("您输入的不是整数");
            return;
        }
    }

    /**
     * 一个5位数，判断它是不是回文数。
     * 即12321是回文数，个位与万位相同，十位与千位相同。
     */
    private static void questionSix(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("请输入一个5位的整数：");
        try {
            int num=scanner.nextInt();
            String numStr=String.valueOf(num);
            char[] chars=numStr.toCharArray();
            if(chars.length!=5){
                System.out.println("您输入的数字不是5位!");
                return;
            }
            for (int i=0;i<chars.length/2;i++){
                if (chars[i]!=chars[chars.length-1-i]){
                    System.out.println("您输入的数字不是回文数");
                    return;
                }
            }
            System.out.println("您输入的数字是回文数!");
        }catch (Exception e){
            System.out.println("您输入的不是整数!");
            return;
        }
    }

    /**
     * 请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续判断第二个字母。
     */
    private static void questionSeven(){
        String[] week={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入第一个字母(输入多个取第一个):");
        char c=scanner.next().charAt(0);
        if (!untils.isLetter(c)){
            System.out.println("您输入的第一个字符不是字母!");
            return;
        }
        List<String> spareList=new ArrayList<>();
        for (String str:week){
            if (str.charAt(0)==c||str.charAt(0)==untils.changeCase(c)){
                spareList.add(str);
            }
        }
        if (spareList.size()>1){
            System.out.println("请输入第二个字母(输入多个取第一个):");
            c=scanner.next().charAt(0);
            if (!untils.isLetter(c)){
                System.out.println("您输入的第一个字符不是字母!");
                return;
            }
            for (String str:spareList){
                if (str.charAt(1)==c||str.charAt(1)==untils.changeCase(c)){
                    System.out.println(str);
                    return;
                }
            }
            System.out.println("您输入的字母不对!");
            return;
        }
        if (spareList.size()<1){
            System.out.println("您输入的字母不对!");
            return;
        }
        System.out.println(spareList.get(0));
    }

    /**
     * 对10个数进行排序
     */
    private static void questionEight(){
        Scanner scanner=new Scanner(System.in);
        List<Double> sumList=new ArrayList<>();
        try {
            for (int i=1;i<=10;i++){
                System.out.println("请输入第"+i+"个数:");
                sumList.add(scanner.nextDouble());
            }
        }catch (Exception e){
            System.out.println("请输入数字!");
            return;
        }
        for (int i=0;i<10;i++){
            for (int j=i;j<10;j++){
                if (sumList.get(i).compareTo(sumList.get(j))>0){
                    double d=sumList.get(i);
                    sumList.set(i,sumList.get(j));
                    sumList.set(j,d);
                }
            }
        }
        System.out.println(sumList);
    }

    /**
     * 求一个3*3矩阵对角线元素之和
     */
    private static void questionNine() {
        Random random = new Random();
        int[][] arr = new int[3][3];
        int sumForward=0;
        int sumReverse=0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                arr[i][j] = random.nextInt();
            }
        }
        System.out.println("随机矩阵为：");
        for (int i=0;i<3;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]);
            sumForward+=arr[i][i];
        }
        for (int i=0;i<3;i++){
            sumReverse+=arr[i][2-i];
        }
        System.out.println("正向对角之和为："+sumForward);
        System.out.println("逆向对角之和为："+sumReverse);
    }
}
