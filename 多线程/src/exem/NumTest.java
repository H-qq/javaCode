package exem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author hongtao
 * @create 2022-04-07-13:40
 */

public class NumTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int []nums = new int[7];
        Arrays.sort(nums);
        int minNum = nums[0];
        int maxNum = nums[6];
        int addBc = maxNum-minNum;
        for (int i = 0; i < 6; i++) {
            int b = nums[i];
            for (int j = i+1; j < 6; j++) {
                if (addBc == b+nums[j]) {
                    int c = nums[j];
                    break;
                }
            }
        }
        System.out.println(minNum);
        System.out.println();
    }
}
