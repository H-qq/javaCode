package homework;

import upload.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hongtao
 * @create 2022-04-27-22:45
 */
@SuppressWarnings("all")
public class HomeworkServer2 {
    public static void main(String[] args) throws Exception {
        //监听 端扣 9999 等待客户端连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待客户端连接");
        //等待客户端连接
        Socket socket = serverSocket.accept();
        //读取客户端下载名字名
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        String downLoadFileName = "";
        while ((len = inputStream.read(buf)) != -1) {
            downLoadFileName += new String(buf, 0, len);
        }
        System.out.println("客户端需要下载的文件名：" + downLoadFileName);
        String resFileName = "";
        if ("高山流水".equals(downLoadFileName)) {
            resFileName = "D:\\高山流水.mp3";
        } else {
            resFileName = null;
        }
        //开始读取文件
        //创建一个输入流 读取文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(resFileName));
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //打回数据通道
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);
        socket.shutdownOutput();  //结束标记
        //关闭
        inputStream.close();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        serverSocket.close();
        socket.close();
        System.out.println("服务端退出!");


    }
}
