package day12;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author hongtao
 * @create 2022-04-23-14:40
 */

public class BuffWriter {
    public static void main(String[] args) throws Exception {
        String path = "d:\\news001.txt";
        //new FileWriter(path,true) 表示以追加方式写入
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        bufferedWriter.write("hello qq!");
        //插入一个换行
        bufferedWriter.newLine();
        bufferedWriter.write("牛");
        //关闭外层流即可，传入的new FileWriter(path) 会在底层关闭
        bufferedWriter.close();
    }
}
