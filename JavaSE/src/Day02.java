import java.math.BigDecimal;
import java.util.Scanner;

public class Day02 {

    public static void main(String[] args) {
//        questionOne();
//        questionTwo();
//        questionThree();
        questionFour();
    }

    /**
     * 输入一行字符，分别统计出其英文字母、空格、数字和其它字符的个数。
     */
    private static void questionOne(){
        Scanner scanner=new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("请输入字符串：");
        String str=scanner.next();
        int num=0,space=0,letter=0,pun=0;
        char[] chars=str.toCharArray();
        for (int i=0;i<chars.length;i++){
            int ascii=chars[i];
            if(ascii>='0'&&ascii<='9'){
                num++;
            }else if (ascii==' '){
                space++;
            }else if((ascii>='a'&&ascii<='z')||(ascii>='A'&&ascii<='Z')){
                letter++;
            }else {
                pun++;
            }
        }
        System.out.println("数字有"+num+"个,字母有"+letter+"个,空格有"+space+"个,其他符号有"+pun+"个");
    }

    /**
     * 求s=a+aa+aaa+aaaa+aa…a的值，其中a是一个数字。
     * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。输出结果的形式如：2+22+222=246；
     */
    private static void questionTwo(){
        Scanner scanner=new Scanner(System.in);
        int a=0;
        while (true) {
            System.out.println("请输入a(范围为-9到9)：");
            a = scanner.nextInt();
            if (a > 9 || a < -9) {
                System.out.println("输入的数字不在范围内，请重新输入！");
                a = scanner.nextInt();
                continue;
            }
            break;
        }
        System.out.println("请输入数字个数：");
        String str=""+a;
        int num=scanner.nextInt();
        int sum=0;
        for (int b=a;num>0;num--){
            sum+=b;
            if (b>a){
                str=str+"+"+b;
            }
            b=b*10+a;
        }
        System.out.println(str+"="+sum);
    }

    /**
     * 一个数如果恰好等于它的因子之和，这个数就称为”完数”。
     * 例如6=1＋2＋3.编程找出1000以内的所有完数。
     */
    private static void questionThree(){
        for(int i=1;i<1000;i++){
            int sum=1;
            for (int j=2;j<i;j++){
                if (i%j==0){
                    sum+=j;
                }
            }
            if (sum==i){
                System.out.println(i);
            }
        }
    }

    /**
     * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；n次落地经过路线总长度和下次反弹的高度。
     */
    private static void questionFour(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入n：");
        int n=scanner.nextInt();
        BigDecimal high=new BigDecimal("50");
        BigDecimal distance=new BigDecimal("100");
        BigDecimal divide=new BigDecimal("2");
        for (int i=1;i<n;i++){
            distance=distance.add(high).add(high);
            high=high.divide(divide);
        }
        System.out.println("总路程为："+distance);
        System.out.println("下一次高度为："+high);
    }
}
