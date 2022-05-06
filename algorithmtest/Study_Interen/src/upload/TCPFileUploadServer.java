package upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hongtao
 * @create 2022-04-27-14:02
 * 服务端
 */

public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //1.服务端 监听 端口：8888
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("正在监听");
        //2.等待连接
        Socket socket = serverSocket.accept();
        //创建读取磁盘文件的输入流
        //读取客户端发送的数据集
        //通过Socket得到输入流
        BufferedInputStream bufferedInputStream1 = new BufferedInputStream(socket.getInputStream());
        byte[] bytes1 = StreamUtils.streamToByteArray(bufferedInputStream1);
        //将得到的bytes1  数组 写到指定路径，得到文件
        String path = "src\\1.png";
        BufferedOutputStream bufferedOutputStream1 = new BufferedOutputStream(new FileOutputStream(path));
        bufferedOutputStream1.write(bytes1);
        bufferedOutputStream1.close();
        //向客户端回复 ”收到图片“
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片!");
        bufferedWriter.flush(); //刷新
        socket.shutdownOutput();//设置结束标记
        bufferedWriter.close();


        bufferedInputStream1.close();
        socket.close();

    }
}
