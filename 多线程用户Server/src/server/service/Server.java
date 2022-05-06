package server.service;

import common.Message;
import common.MessageType;
import common.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author hongtao
 * @create 2022-04-28-23:20
 * //这是服务器，在监听9999  等待客户端连接
 */

public class Server {
    private ServerSocket serverSocket = null;
    //可以处理并发的集合 没有线程安全问题 用 ConcurrentHashMap
    //创建一个集合 存放多个用户 如果是这些用户登入 ，认为是合法的
    private static HashMap<String,User> validUser = new HashMap<>();

    static {//j静态代码块初始 初始化
        validUser.put("100",new User("100","010919"));
        validUser.put("101",new User("101","010919"));
        validUser.put("102",new User("102","010919"));
        validUser.put("七七",new User("七七","010919"));
        validUser.put("小七",new User("小七","010919"));
    }
    //验证用户是否有效的方法
    private static  boolean checkUser(String userId,String passwd){
        User user = validUser.get(userId);
        if (user == null){
            System.out.println("账号不存在！");
            return false;
        }else if(!user.getPasswd().equals(passwd)){
            System.out.println("账号或密码错误！");
            return false;
        }
        return  true;
    }

    private Socket socket;

    public Server() {
        //注意：端口可以写在配置文件中
        System.out.println("服务端在监听");
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {//当和某个客户端连接后，会继续监听 因此while
                socket = serverSocket.accept();
                //得到Socket关联的对象输入流
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                //读取客户端发送的User对象
                User u = (User) objectInputStream.readObject();
                //创建一个Messaged对象，回复客户端
                Message message = new Message();
                //创建输出流 打回数据
                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                //验证用户
                if (checkUser(u.getUserId(),u.getPasswd())) {
                    //验证通过
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象发送回客户端
                    objectOutputStream.writeObject(message);
                    //创建线程，和客户端保持通信,该线程持有Socket对象
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, u.getUserId());
                    //启动线程
                    serverConnectClientThread.start();
                    //该线程对象放入集合进行管理
                    ManageServerThread.addClientThread(u.getUserId(), serverConnectClientThread);

                } else {
                    //登入失败 不合法
                    System.out.println("用户 id="+u.getUserId()+"\t密码="+u.getPasswd()+"登入失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    objectOutputStream.writeObject(message);
                    //关闭Socket
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //如果服务端退出while循环 说明 不在监听 关闭资源
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

}
