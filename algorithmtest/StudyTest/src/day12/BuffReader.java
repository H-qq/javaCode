package day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author hongtao
 * @create 2022-04-23-14:25
 */

public class BuffReader {
    public static void main(String[] args) throws Exception {
        String path = "d:\\news.txt";
        //创建bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        //读取
        String line;//按行读取，效率高
        //bufferedReader.readLine(); 按行读取 返回空 表示读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        //关闭流,只需要关闭外层流BufferedReader ，因为底层会自动关闭节点流  FileReader
        bufferedReader.close();
    }
}
