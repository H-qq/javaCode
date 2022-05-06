package day11;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author hongtao
 * @create 2022-04-22-19:21
 */
@SuppressWarnings("all")
public class FileReaderTest {
    public static void main(String[] args) {
        String file = "d:\\news.txt";
        //1、创建FileReader对象
        FileReader fileReader = null;
        int data = 0;
        try {
            fileReader = new FileReader(file);

            //读取  使用read
            //单个字符读取
            while ((data = fileReader.read())!= -1){
                System.out.print((char) data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    //加强版
    @Test
    public void test(){
        String file = "d:\\news.txt";
        //1、创建FileReader对象
        FileReader fileReader = null;
        int readLen = 0;
        char[] buf = new char[8];
        try {
            fileReader = new FileReader(file);
            //读取  使用read
            //多个读取 使用read（buf） 返回实际读取字符数
            //如果返回-1 说明文件借宿
            while ((readLen = fileReader.read(buf))!= -1){
                System.out.print(new String(buf,0,readLen));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
