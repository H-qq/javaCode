package day10;

import org.junit.Test;

import java.io.File;

/**
 * @author hongtao
 * @create 2022-04-22-12:53
 */

public class FileInformation {
    public static void main(String[] args) {

    }
    @Test
    public void info(){
        //先创建文件对象
        File file = new File("d:\\news1.txt");
        //调用相应的方法，得到对应的信息
        System.out.println("文件信息="+file.getName());
        System.out.println("文件绝对路径="+file.getAbsolutePath());
        System.out.println("文件父级目录="+file.getParent());
        System.out.println("文件大小（字节）="+file.length());
        System.out.println("文件是否存在="+file.exists());
        System.out.println("是不是文件="+file.isFile());

    }
    @Test
    public void m1(){
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete()){
                System.out.println("删除成功！");
            }else {
                System.out.println("删除失败！");
            }
        }else {
            System.out.println("该文件不存在！");
        }
    }
}
