package day04;

import java.util.Scanner;

/**
 * @author hongtao
 * @create 2022-04-14-19:32
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */

public class ReplaceTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ReplaceTest rs = new ReplaceTest();
        System.out.println(rs.replaceSpace(s));
    }
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i)==' '){
                res.append("%20");
            }else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
