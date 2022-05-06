package day01;
import java.util.Scanner;
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入的你的名字：");
        String name = scanner.next();
        System.out.println(name);
        System.out.println("请输入你的年龄：");
        int age = scanner.nextInt();
        System.out.println(age);
    }
}
