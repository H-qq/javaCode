package day13;

import java.io.PrintStream;

/**
 * @author hongtao
 * @create 2022-04-24-16:08
 */

public class PrintStream_ {
    public static void main(String[] args) throws Exception {
        PrintStream out = System.out;
        //在默认情况下，PrintStream输出数据的位置时 标准输出，即显示器
        out.println("hello");
        out.close();

        //我们可以修改打印流输出的位置/设备
        System.setOut(new PrintStream("d:\\01.txt"));
        System.out.println("hello 你好牛");
    }
}
