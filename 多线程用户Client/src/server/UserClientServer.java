package server;

import common.Message;
import common.MessageType;
import common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author hongtao
 * @create 2022-04-28-22:23
 *
 * 该类完成用户登入和用户注册方法
 */

public class UserClientServer {
    private static User u = new User();//
    //因为Socket也要使用 因此也要作为属性
    private static   Socket socket;
    public boolean checkUser(String userId,String pwd){
        boolean b = false;
        //创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);
        //连接到服务器，发送u对象
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //得到ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u); //发送user对象

            //从服务端回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms =(Message) ois.readObject();

            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){

                b  = true;
                //表示登入成功
                //开始创建一个多线程和服务器端保持通信的线程 -->创建一个类 Client 连接 Server 线程
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //启动线程
                clientConnectServerThread.start();
                //为了客户端的扩展 将线程放入集合中管理
                MangeClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);
                b =true;

            }else {
                //登入失败 不能启动线程 ，但是Socket还是可以
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }
    //向服务器端写一个在线列表
    public static void onlineFriendList(){
        //发送一个 Message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());

        //发送给服务器
        try {
            //应该得到当前线程的Socket  对应的 ObjectOutputStream
            //从管理线程的集合中，先得到一个线程
            ClientConnectServerThread clientConnectServerThread =
                    MangeClientConnectServerThread.getClientConnectServerThread(u.getUserId());
            //通过线程得到管理的Socket对应线程对象
            Socket socket = clientConnectServerThread.getSocket();
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message); //发送一个Message ，向服务端得到列表
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //编写方法，退出客户端
    public static void  layout(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());//一定要指定哪个客户端id

        //发送 message
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
            System.out.println(u.getUserId()+"退出系统");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

