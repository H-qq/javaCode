package day13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author hongtao
 * @create 2022-04-24-15:54
 */
@SuppressWarnings("all")
//将字节流FileInputStream 转换字符流 InputStreamReader
public class InputStreamReader_ {
    public static void main(String[] args) throws Exception {
        String path = "d:\\01.txt";
        //1,FileInputStream 转换成  InputStreamReader
        // InputStreamReader isr = new InputStreamReader(new FileInputStream(path),"UTF-8");
        //2.把InputStreamReader 传入BufferedReader（isr）
        //BufferedReader br = new BufferedReader(isr);

        //将 1 和 2 一起写
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        //3.读取
        String s = br.readLine();
        System.out.println(s);
        br.close();
    }
}
