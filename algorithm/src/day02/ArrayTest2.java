package day02;
import java.util.Scanner;
public class ArrayTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入输入学生个数：");
        int num = scanner.nextInt();
        int Num[] =  new int[num];
        System.out.println("请输入学生成绩：");
        for (int i =0;i<Num.length;i++){
            Num[i] = scanner.nextInt();
        }
        int max = 0;
        for (int i = 0;i<Num.length;i++){
            if (max < Num[i]){
                max = Num[i];
            }
        }
        char level;
        for (int i =0;i<Num.length;i++){
            if (max-Num[i] <= 10){
                level = 'A';
            }else if (max-Num[i]  <= 20){
                level = 'B';
            }else if (max-Num[i] <= 30){
                level = 'C';
            }else {
                level = 'D';
            }
            System.out.println("student"+i+"socre is "+Num[i]+
                    "grade is"+level );
        }
    }
}
