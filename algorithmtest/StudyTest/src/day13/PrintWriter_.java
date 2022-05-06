package day13;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author hongtao
 * @create 2022-04-24-16:16
 */

public class PrintWriter_ {
    public static void main(String[] args) throws Exception{
       // PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("d:\\01.txt"));
        printWriter.println("你好牛牛");
        printWriter.close();
    }
}
