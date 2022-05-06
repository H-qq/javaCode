package upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author hongtao
 * @create 2022-04-27-14:03
 * 客户端
 */

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //创建客户端连接服务，得到Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 7777);
        String filePath = "D:\\download\\repository-open-graph-template.png";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));

        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //通过Socket获取到输出流 ，将bytes 到服务端q2
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);  //将文件对应的对应数组内容写入到通道
        bufferedInputStream.close();
        socket.shutdownOutput(); //设置写入的数据的结束标记

        InputStream inputStream = socket.getInputStream();
        //使用Stream方法转成字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);


        //关闭
        inputStream.close();
        bufferedOutputStream.close();
        socket.close();

    }
}
