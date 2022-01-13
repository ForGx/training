import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) {
//        questionOne();
//        questionTwo();
//        questionThree();
//        questionFour();
//        questionFive();
        questionSix();
    }

    /**
     * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少？
     */
    private static void questionOne(){
        String a;
        while (true) {
            System.out.println("请输入查询月(输入S结束)：");
            Scanner scanner = new Scanner(System.in);
            a = scanner.next();
            if ("S".equals(a)){
                return;
            }
            System.out.println("第" + a + "个月有" + funOne(Integer.parseInt(a)) + "对兔子");
        }
    }
    static int funOne(int n){
        //假设第n个月的兔子对数为f(n)，因为第n个月的兔子对数为前两月兔子对数之和，则f(n)=f(n-1)+f(n-2)
        if (n<3){
            return 1;
        }
        return funOne(n-1)+funOne(n-2);
    }

    /**
     * 判断101-200之间有多少个素数，并输出所有素数。
     */
    private static void questionTwo(){
        int i=101;
        int sum=0;
        for (;i<200;i++){
            for(int j=2;j<i;j++){
                if ((i%j)==0){
                    break;
                }
                if (j==(i-1)){
                    System.out.println(i);
                    sum++;
                }
            }
        }
        System.out.println("一共有"+sum+"个素数");
    }

    /**
     * 打印出所有的”水仙花数”，所谓”水仙花数”是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个”水仙花数”，因为153=1的三次方＋5的三次方＋3的三次方。
     */
    private static void questionThree(){
        for (int i=100;i<1000;i++){
            if(i==(Math.pow(i/100,3)+Math.pow(i/10-((i/100)*10),3)+Math.pow(i-((i/10)*10),3))){
                System.out.println(i);
            }
        }
    }

    /**
     * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
     */
    private static String ss;
    private static void questionFour(){
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("请输入要分解的数字(输入S结束)：");
            String a = scanner.next();
            if ("S".equals(a)){
                return;
            }
            ss=a+"=";
            funFour(Integer.parseInt(a));
            System.out.println(ss);
        }
    }
    static int funFour(int n){
        for (int i=2;i<n/2;i++){
            if (n%i==0){
                ss=ss+i+"*";
                return funFour(n/i);
            }
        }
        ss=ss+n;
        return n;
    }

    /**
     * 利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
     */
    private static void questionFive(){
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("请输入成绩(输入S结束)：");
            String a = scanner.next();
            if ("S".equals(a)) {
                return;
            }
            String s=Integer.parseInt(a)>=90? "A":Integer.parseInt(a)>=60? "B":"C";
            System.out.println("该学生的最终评级为:"+s);
        }
    }

    /**
     * 输入两个正整数m和n，求其最大公约数和最小公倍数。
     */
    private static void questionSix(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入m：");
        int m=scanner.nextInt();
        System.out.println("请输入n：");
        int n=scanner.nextInt();
        int divisorMax=0;
        int multipleMin=m*n;
        for (int i=1 ; i<=m&&i<=n;i++){
            if(m%i==0&&n%i==0){
                divisorMax=i;
            }
        }
        multipleMin = multipleMin/divisorMax;
        System.out.println("最大公约数为："+divisorMax);
        System.out.println("最小公倍数："+multipleMin);
    }
}
