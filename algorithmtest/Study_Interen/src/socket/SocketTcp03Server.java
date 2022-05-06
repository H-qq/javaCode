package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hongtao
 * @create 2022-04-26-22:08
 */
//服务端  字符流
public class SocketTcp03Server {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 在本机 的9999端口监听, 等待连接
        //   细节: 要求在本机没有其它服务在监听9999
        //   细节：这个 ServerSocket 可以通过 accept() 返回多个Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("正在被连接");
        //2. 当没有客户端连接9999端口时，程序会 阻塞, 等待连接
        //   如果有客户端连接，则会返回Socket对象，程序继续
        Socket socket = serverSocket.accept();
        //3. 通过socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
        InputStream inputStream = socket.getInputStream();

        //字符流读取    将字节转换成字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s); //输出
        OutputStream outputStream = socket.getOutputStream();
        //使用字符数处理的方式回复信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello client 字符流");
        bufferedWriter.newLine(); //换行 表示结束
        bufferedWriter.flush();

        br.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
