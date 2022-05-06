package day01;

import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @author hongtao
 * @create 2022-04-09-19:06
 */

public class greedTest {


    @Test
    public void test(){
        int a = (int)('0');
        System.out.println('A'-'a');
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int[] p = new int [26];
        for (int i = 0; i < 26; i++) {
            p[str.charAt(i)-'a']=i;
        }
        String str1 = scanner.next();
         int res = 1;
        for (int i = 1; i < str1.length(); i++) {
            if (p[str1.charAt(i)-'a']<=p[str1.charAt(i-1)-'a']) {
                res += 1;
            }
        }
        System.out.println(res);
    }
}
