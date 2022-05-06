package day01;
import java.util.Scanner;
public class IfTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int[][] a3 = new int[row][row];
        int[] a1 = new int[row];
        for (int i = 0; i < a3.length; i++) {
            for (int j = 0; j < a3[i].length; j++) {
                a3[i][j] = i;
            }

        }
        for (int i = 0; i < a3.length; i++) {
            for (int j = i; j < a3[i].length; j++) {
                System.out.println(a3[i][j] + " ");
            }

        }
    }
}
