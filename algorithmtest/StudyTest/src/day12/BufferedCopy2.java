package day12;

import java.io.*;

/**
 * @author hongtao
 * @create 2022-04-23-15:37
 */

//演示使用BufferedOutputStream 和 BufferedInputStream

public class BufferedCopy2 {
    public static void main(String[] args) {
        String path = "d:\\1.png";
        String destpath = "d:\\2.png";
        BufferedInputStream bs = null;
        BufferedOutputStream bp = null;
        try {
            //因为FileInputStream 是 InputStream 子类
            bs = new BufferedInputStream(new FileInputStream(path));
            bp = new BufferedOutputStream(new FileOutputStream(destpath));

            //循环读取文件
            byte[] buf = new byte[1024];
            int readLen = 0;
            //当返回-1表示文件读取完毕
            while ((readLen = bs.read(buf)) != -1) {
                bp.write(buf, 0, readLen);
            }
            System.out.println("文件复制成功！");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (bs != null && bp != null) {
                try {
                    bs.close();
                    bp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
