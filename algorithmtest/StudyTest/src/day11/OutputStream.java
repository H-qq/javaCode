package day11;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author hongtao
 * @create 2022-04-22-17:10
 */

public class OutputStream {
    @Test
    public void test1() throws IOException{
        //创建 FileOutputStram
        String filePath = "D:\\news2.txt";
        FileOutputStream fileOutputStream = null;
        String str = "hello,world!";
        try {
            //得到FileOutputStream对象
            fileOutputStream = new FileOutputStream(filePath,true);//使用True 不会覆盖原文件内容
            //写入一个字节
            fileOutputStream.write(str.getBytes());

            System.out.println("写入成功!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
