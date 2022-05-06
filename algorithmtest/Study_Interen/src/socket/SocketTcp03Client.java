package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author hongtao
 * @create 2022-04-26-22:08
 */
//客户端 字符流
public class SocketTcp03Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999端口, 如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //2. 连接上后，生成Socket, 通过socket.getOutputStream()
        //   得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3. 通过输出流，写入数据到 数据通道  使用字符流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("你好！字符流");
        bw.newLine();  //插入一个换行符 表示内容结束,注意，要求对方使用 readLine（）！！！！
        bw.flush();  //如果使用的是字符流，需要手动刷新，否则数据不会写入通道
       //socket.shutdownOutput();
        //4.获取和Socket关联的输入流，读取数据（字节），并显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        bw.close();
        bufferedReader.close();
        socket.close();
    }
}
