package day01;
import java.util.Scanner;
public class ForTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数m的值：");
        int m = scanner.nextInt();
        System.out.println("请输入第二个数n的值:");
        int n =  scanner.nextInt();
        //比较最小的值
        int min = (m<n) ? m : n;
        for (int i = min;i>=0;i--){
            if (m%i==0 && n%i==0){
                System.out.println("最大公约数："+i);
                break;
            }
        }
        int max = (m>=n)? m:n;
        for (int i = max;i<=m * n;i++){
            if(i%n==0&&i%m==0){
                System.out.println("最小公倍数："+i);
                break;
            }
        }

    }
}
