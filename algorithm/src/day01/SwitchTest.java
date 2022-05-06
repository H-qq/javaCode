package day01;
import java.util.Scanner;
public class SwitchTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生成绩：");
        int score = scanner.nextInt();
        int scores = score /10;
        switch (scores){
            case 10:
                System.out.println("等级：A");
            case 9:
                System.out.println("等级：A");
                break;
            case 8:
                System.out.println("等级：B");
            case 7:
                System.out.println("等级：B");
                break;
            case 6:
                System.out.println("等级：C");
                break;
            default:System.out.println("等级：D");
        }
    }
}
