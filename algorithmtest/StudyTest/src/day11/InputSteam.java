package day11;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author hongtao
 * @create 2022-04-22-13:47
 */

public class InputSteam {

    @Test
    //演示FileInputStream的使用（字节输入流 文件-->程序）
    public void test1(){
        String filePath = "d:\\hello.txt";
        int readDate = 0;
        byte[] buf = new byte[8];//一次读取八个字节
        int readLen = 0;
        FileInputStream fileInputStream=null;
        try {
            //创建FileInputStream对象，用来读取
           fileInputStream = new FileInputStream(filePath);
            //如果read 返回-1 表示读取完毕
            //使用read[byte[]]数组
            //返回正常，返回实际取取字符数
            while((readLen = fileInputStream.read(buf))!=-1){
                System.out.print(new String(buf,0,readLen));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭文件，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
