package housework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author hongtao
 * @create 2022-04-24-16:53
 *
 *  1)判断d盘下是否有文件Mytemp ，如果没有就创建
 *  2）在mytemp 目录下 创建hello.txt
 *  3)如果已经存在hello。txt ，提示文件已经存在
 *  4)并在hello.txt 写入hello，world
 */

public class Homewor01 {
    public static void main(String[] args)throws  Exception {
        String path = "d:\\mytemp";
        File file = new File(path);
        if (!file.exists()){
            //创建目录
            if (file.mkdir()){
                System.out.println("创建成功！");
            }else {
                System.out.println("创建失败!");
            }
        }
        String filePath = path+"\\hello.txt";
       file =  new File(filePath);
       if (!file.exists()){
           //创建文件
           if (file.createNewFile()){
               System.out.println(filePath+"创建成功！");
           }else {
               System.out.println(filePath+"创建失败！");
           }
       }else {
           System.out.println(filePath+"已经存在");
       }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
       bufferedWriter.write("hello ,world~");
       bufferedWriter.close();
    }
}
