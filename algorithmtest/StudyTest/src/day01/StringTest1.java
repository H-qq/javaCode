package day01;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author hongtao
 * @create 2022-04-11-15:41
 */

public class StringTest1 {
    @Test
    public void test3(){
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
    }
    @Test
    public void test2(){
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }
        char[] arr = new char[]{'h','e','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }
    @Test
    public void test1(){
        String str1 = "123";
        int num = Integer.parseInt(str1);
        System.out.println(num);

        String str2 = String.valueOf(num);
        System.out.println(str2 instanceof String);
    }

}
