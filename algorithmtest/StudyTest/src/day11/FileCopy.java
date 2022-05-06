package day11;

import java.io.*;

/**
 * @author hongtao
 * @create 2022-04-22-17:29
 */

public class FileCopy {
    public static void main(String[] args) {
        //完成 文件拷贝 进行复制
        //1.创建文件输入流，将文件读入到程序
        //2创建文件输出流，将读取到的文件数据，写入到指定的文件
        String srcfilePath = "d:\\news.txt";
        String destFilePath = "d:\\IOtest\\news.txt";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try{
            fileInputStream = new FileInputStream(srcfilePath);
            fileOutputStream = new FileOutputStream(destFilePath);

            //定义一个字节数组提高效率
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf))!= -1){
                //读取到，就写入文件通过FileOutputStream
                fileOutputStream.write(buf,0,readLen);//一定要用这个方法
            }
            System.out.println("复制成功");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭输入流与输出流
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
                if (fileOutputStream != null){
                    fileOutputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
