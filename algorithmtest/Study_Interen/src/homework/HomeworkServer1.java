package homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hongtao
 * @create 2022-04-27-20:23
 */

public class HomeworkServer1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("正在连接");

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        String answer = "";
        if ("name".equals(s)) {
            answer = "我是七七";
        } else if ("hobby".equals(s)) {
            answer = "打王者荣耀";
        } else {
            answer = "不太懂";
        }
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(answer);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedReader.close();


        socket.close();
        serverSocket.close();

    }
}
