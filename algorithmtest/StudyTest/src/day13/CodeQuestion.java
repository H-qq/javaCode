package day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author hongtao
 * @create 2022-04-24-15:40
 */

public class CodeQuestion {
    public static void main(String[] args) throws Exception{
        //读取 文件
        //思路
        //1.创建一个输入流 BufferedReader[处理流]
        //2.使用BufferedReader 对象读取
        //3.默认情况下，读取文件时 utf-8 编码
        String path = "d:\\01.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String s = br.readLine();
        System.out.println(s);
        br.close();
    }
}
