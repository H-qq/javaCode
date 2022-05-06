package server;

import common.Message;
import common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author hongtao
 * @create 2022-05-03-21:18
 *
 * 该类、对象提供和消息相关的服务方法
 */

public class MessageClientServer {
    public static void sendMessageToAll(String content,String senderId){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);//群发的聊天消息
        message.setSender(senderId);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println("发送成功！");
     //   System.out.println(senderId+"对"+"大家说"+content);
        //发送给服务器
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(MangeClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void sendMessageToOne(String content,String senderId,String getId){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);//普通的聊天消息
        message.setSender(senderId);
        message.setGetter(getId);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println(senderId+"对"+getId+"说"+content);
        //发送给服务器
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(MangeClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
