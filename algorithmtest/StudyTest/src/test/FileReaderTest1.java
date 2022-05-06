package test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author hongtao
 * @create 2022-04-22-19:38
 */

public class FileReaderTest1 {
    public static void main(String[] args) throws IOException{
        String  path = "d:\\news2.txt";
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        int readLen = 0;
        char[] buf = new char[8];
        char[] chars = {'a','b','c'};

        try{
            fileWriter = new FileWriter(path,true);

            //1，单个写入字符
            fileWriter.write("H");
            //2.写入指定数组
            fileWriter.write(chars);
            //3.写入指定数组的指定部分
            fileWriter.write("牛逼哈",0,3);
            //4.写入整个字符
            fileWriter.write("你最牛！");
            System.out.println("写入成功");
            fileReader= new FileReader(path);
            while((readLen = fileReader.read(buf))!=-1){
                System.out.println(new String(buf,0,readLen));
            }


        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fileWriter!=null && fileReader!=null){
                    fileWriter.close();
                    fileReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
