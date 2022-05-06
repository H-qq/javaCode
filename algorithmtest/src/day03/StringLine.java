package day03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hongtao
 * @create 2022-04-12-16:57
 * 示例 2:
 * 输入:
 * widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "bbbcccdddaaa"
 * 输出: [2, 4]
 * 解释:
 * 除去字母'a'所有的字符都是相同的单位10，并且字符串 "bbbcccdddaa" 将会覆盖 9 * 10 + 2 * 4 = 98 个单位.
 * 最后一个字母 'a' 将会被写到第二行，因为第一行只剩下2个单位了。
 * 所以，这个答案是2行，第二行有4个单位宽度。

 */

public class StringLine {
    public static void main(String[] args) {
        Scanner s1 =new Scanner(System.in);
        String s = s1.next();
        int[] widths = new int[26];
        for (int i = 0; i < 26 ;i++) {
            widths[i] = s1.nextInt();
        }
        StringLine sL = new StringLine();
        sL.numberOfLines(widths,s);

    }
    public int[] numberOfLines(int[] widths, String s) {
        int count = 1;
        int mul = 0;
        int finlen = 0;
        int [] result = new int[2];
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = s.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
                mul += widths[res[i]-'a'];
                if (mul%100<10 && count!=1){
                    if (100*(count-1)-(mul-widths[res[i]-'a'])<mul-widths[res[i]-'a']){
                        finlen = widths[res[i]-'a'];
                        count+=1;
                    }else {
                        finlen = mul%10;
                    }
                }else if (mul>=100){
                    finlen = mul%100;
                    count+=1;
                }else {
                    finlen = mul%100;
                }
        }

       result[0] = count;
       result[1] = finlen;
        System.out.println(Arrays.toString(result));
        return result;
    }
}
