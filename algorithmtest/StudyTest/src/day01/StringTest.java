package day01;

import org.junit.Test;

import java.util.Locale;

/**
 * @author hongtao
 * @create 2022-04-10-15:44
 */

public class StringTest {
    @Test
    public void test3(){
        String s1 = "HelloWord";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.isEmpty());
        System.out.println(s1.toLowerCase(Locale.ROOT));
        String s2= "HelloWord   ";
        String s3 = s2.trim();
        System.out.println(s3.equals(s2));
        String s4 = "abc";
        System.out.println(s4.compareTo(s1));
        String s5 = "每日一题";
        System.out.println(s5.substring(2));
        System.out.println(s5.substring(1, 3));


    }
    @Test
    public void test2(){
        //此时s1 s2 的数据是存放在字符串常量池中
        String s1 = "JavaEE";
        String s2 = "JavaEE";
        System.out.println(s1==s2);
        //此时s3 s4 的数据实在堆空间中
        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");
        System.out.println(s3.equals(s4));

    }
    @Test
    public void test1(){
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";
        //s1 = "hello";
        System.out.println();
    }
}
