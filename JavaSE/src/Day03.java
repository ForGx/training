import java.math.BigDecimal;
import java.util.Scanner;

public class Day03 {

    public static void main(String[] args) {
//        questionOne();
//        questionTwo();
        questionThree();
    }

    /**
     * 有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
     */
    private static void questionOne(){
//        String[] strings={"1","2","3","4"};
        int num=0;
        for (int i=1;i<=4;i++){
            for (int j=1;j<=4;j++){
                if(j==i){
                    continue;
                }
                for (int k=1;k<=4;k++){
                    if (k==j||k==i){
                        continue;
                    }
                    num++;
                    System.out.println(""+i+j+k);
                }
            }
        }
        System.out.println("一共"+num+"个3位数");
    }

    /**
     * 企业发放的奖金根据利润提成。
     * 利润(I)低于或等于10万元时，奖金可提10%；
     * 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可提成7.5%；
     * 20万到40万之间时，高于20万元的部分，可提成5%；
     * 40万到60万之间时高于40万元的部分，可提成3%；
     * 60万到100万之间时，高于60万元的部分，可提成1.5%，
     * 高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润I，求应发放奖金总数？
     */
    private static void questionTwo(){
        Scanner scanner=new Scanner(System.in);
        double profit,commission;
        while (true) {
            System.out.println("请输入利润：");
                String profitStr = scanner.next();
                if (isDouble(profitStr)) {
                    System.out.println("输入有误，请重新输入！");
                    continue;
                }
                profit=Double.valueOf(profitStr);
                break;
        }
        if (profit<=100000){
            commission=profit*0.1;
        }else if (profit<=200000){
            commission=(profit-100000)*0.75+10000;
        }else if (profit<=400000){
            commission=(profit-200000)*0.05+17500;
        }else if (profit<=600000){
            commission=(profit-400000)*0.03+27500;
        }else if (profit<=1000000){
            commission=(profit-600000)*0.015+33500;
        }else {
            commission=(profit-1000000)*0.001+36500;
        }
        System.out.println("奖金为："+commission);
    }
    static boolean isDouble(String str){
        try {
            double num=Double.valueOf(str);
        }catch (Exception e){
//            e.printStackTrace();
            return true;
        }
        return false;
    }

    /**
     * 一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
     */
    private static void questionThree(){
        for (int i=268;;i++){
            if (isSquare(i)){
                if (isSquare(i-168)){
                    System.out.println("该数为："+(i-268));
                    break;
                }
            }
        }
    }
    static boolean isSquare(int x){
        for (int i=1;i<=x;i++){
            if (i*i==x){
                return true;
            }
        }
        return false;
    }
}
