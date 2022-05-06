package server;

import common.Message;
import common.MessageType;

import java.io.*;

/**
 * @author hongtao
 * @create 2022-05-04-15:53
 * 完成文件传输服务
 */

public class FileClientService {
    public static void sendFileToOne(String src,String dest,String senderId,String getterId){
        //读取src文件  -->封装到message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);

        //需要将文件读取
        FileInputStream fileInputStream = null;

        byte[] fileBytes = new byte[(int)new File(src).length()];

        try {
            fileInputStream  = new FileInputStream(src);
            fileInputStream.read(fileBytes);
            //文件对应的字节数组设置message
            message.setFileBytes(fileBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //提示信息
        System.out.println("\n"+senderId+"给"+getterId+"发送文件"+src+"到对方电脑目录"+dest);

        //发送
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(MangeClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
