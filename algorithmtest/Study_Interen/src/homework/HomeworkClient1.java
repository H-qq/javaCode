package homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author hongtao
 * @create 2022-04-27-20:23
 * 提问问题
 *
 */

public class HomeworkClient1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("开始连接");

        OutputStream outputStream = socket.getOutputStream();
        //通过输入流 写到数据通道 ，使用字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        //提问的问题
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题！");
        String question = scanner.next();

        bufferedWriter.write(question);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedReader.close();
        bufferedWriter.close();
       // outputStream.close();
        socket.close();
    }
}
