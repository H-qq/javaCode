package homework;

import upload.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author hongtao
 * @create 2022-04-27-22:45
 */

public class HomeworkClient2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文字名字：");
        String downloadFileName = scanner.next();
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        socket.shutdownOutput();
        //读取服务端返回的文件(字节数据）
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        //得到文件 写入到磁盘
        String destPath = "C:\\Users\\hongtao\\Desktop\\" + downloadFileName + ".mp3";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destPath));
        bufferedOutputStream.write(bytes);
        //socket.shutdownOutput();

        bufferedInputStream.close();
        bufferedOutputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端下载完毕！");

    }
}
