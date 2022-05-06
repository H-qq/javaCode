package day10;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author hongtao
 * @create 2022-04-21-20:25
 */

public class FileCreate {
    public static void main(String[] args) {

    }
    @Test
    //方式一
    public void create01(){
        String filePath = "d:\\news.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    //方式二  new File(File parent,String child)//根据父目录+子路径
    public void creat03(){
        File parentFile = new File("d:\\");
        String fileName = "news2.txt";
        //这里的Fil额，在Java这，只是一个对象
        //只有执行了CreatNameFile，才会真正的创建
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    //方式三
    public void create03(){
        String ParentPath = "d:\\";
        String filePah = "news3.txt";
        File file = new File(ParentPath, filePah);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
