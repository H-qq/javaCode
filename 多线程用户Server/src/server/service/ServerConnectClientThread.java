package server.service;

import common.Message;
import common.MessageType;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author hongtao
 * @create 2022-04-28-23:35
 * 该类的对象和某个客户端保持通信
 */

public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userId;  //连接到服务端的UserId

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() { //这里线程处于run状态，可以发送接受消息
        while (true) {
            System.out.println("服务端与客户端"+userId+"保持通信");
            try {
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Message message = (Message) objectInputStream.readObject();

                //后面会使用Message
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    //客户端在线列表
                    //形式 ： 100 100  至尊宝
                    System.out.println(message.getSender()+"要在线列表");
                    String online = ManageServerThread.getOnline();
                    //返回message
                    //构建一个message  返回给客户端
                    Message message1 = new Message();
                    message1.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message1.setContent(online);
                    message1.setGetter(message.getSender());
                    //写入到数据通道,返回给客户端
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(message1);

                }else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    //遍历管理线程的集合 把所有线程Socket都得到 然后把message进行转发
                    HashMap<String, ServerConnectClientThread> hm = ManageServerThread.getHm();

                    Iterator<String> iterator = hm.keySet().iterator();
                    while(iterator.hasNext()){

                        //取出在线id
                        String OnLineUserId = iterator.next().toString();
                        //排除自己 不给自己进行发送
                        if (!OnLineUserId.equals(message.getSender())){
                            //进行转发
                            ObjectOutputStream objectOutputStream =
                                    new ObjectOutputStream(hm.get(OnLineUserId).getSocket().getOutputStream());
                            objectOutputStream.writeObject(message);
                        }
                    }
                }
                else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    //根据message 获取getId 得到对应线程
                    ServerConnectClientThread serverConnectClientThread =
                            ManageServerThread.getServerConnectClientThread(message.getGetter());
                    //得到Socket的对象输出求，将message 转发指定客户端
                    ObjectOutputStream objectOutputStream =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    objectOutputStream.writeObject(message);//如果用户不在线，则将数据保存到数据库，实现离线

                }else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    ServerConnectClientThread serverConnectClientThread =
                            ManageServerThread.getServerConnectClientThread(message.getGetter());
                    ObjectOutputStream objectOutputStream =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    objectOutputStream.writeObject(message);

                }
                else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    //客户端需要退出
                    System.out.println(message.getSender()+"客户端退出");
                    //将客户端的对应线程从集合中删除
                    ManageServerThread.removeServerConnectClientThread(message.getSender());
                    socket.close();
                    //退出while 循环
                    break;
                }
                else {
                    System.out.println("其它类型 暂时不处理");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public Socket getSocket() {
        return socket;
    }
}
