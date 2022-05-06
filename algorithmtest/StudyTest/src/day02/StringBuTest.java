package day02;

import org.junit.Test;

/**
 * @author hongtao
 * @create 2022-04-11-16:19
 */

public class StringBuTest {
    @Test
    public void test3(){
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
//开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i; }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append('1');
        s1.append(1);
        System.out.println(s1);
        s1.delete(2,4);
        System.out.println(s1);
        System.out.println(s1.replace(2, 4, "hello"));
        System.out.println(s1.insert(2, false));
        System.out.println(s1.length());
        System.out.println(s1.reverse());
        String s2 = s1.substring(1, 3);
        System.out.println(s2);
    }
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1.length());
        System.out.println(new StringBuffer().length());


    }
}
