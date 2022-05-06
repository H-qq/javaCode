package client.view;

import client.utils.Utility;
import server.ClientConnectServerThread;
import server.FileClientService;
import server.MessageClientServer;
import server.UserClientServer;

/**
 * @author hongtao
 * @create 2022-04-28-21:48
 */

public class View {
    public static void main(String[] args) {
        new View().mainMenu();
        System.out.println("客户端退出系统！");
    }
    private boolean loop = true; //控制是否有菜单
    String key = "";
    private UserClientServer userClientServer = new UserClientServer();//用于登入服务器
    private MessageClientServer messageClientServer = new MessageClientServer();//对象用户的私聊
    //显示主菜单
    private void mainMenu(){
        while (loop){
            System.out.println("============欢迎登入网络通信系统===============");
            System.out.println("\t\t 1 登入系统");
            System.out.println("\t\t 9 退出系统");
            System.out.println("请输入你的选择");
            key  = Utility.readString(1);

            //根据用户输入，来处理不同逻辑
            switch (key){
                case "1":
                    System.out.println("登入系统");
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密 码：");
                    String pwd = Utility.readString(50);
                    //需要到服务端该用户是否合法
                    //这里需要多代码 ，这里编写一个类 用于用户登入 + 注册功能
                    if (userClientServer.checkUser(userId,pwd)){ //先进行测试 逻辑
                        System.out.println("============欢迎"+ userId +"（登入成功）===============");
                        //进入二级菜单
                        while (loop){
                            System.out.println("\n===========网络通信系统二级菜单(用户："+userId+")");
                            System.out.println("\t\t 1 显示用户在线列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.println("请输入你的选择");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    //方法获取在线列表
                                    UserClientServer.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("输入对大家说的话：");
                                    String s = Utility.readString(100);
                                    MessageClientServer.sendMessageToAll(s,userId);
                                    break;
                                case "3":
                                    System.out.println("请输入想聊天的用户号（在线）：");
                                    String getId = Utility.readString(50);
                                    System.out.println("请输入想输的话：");
                                    String content = Utility.readString(100);
                                    //编写一个方法
                                    MessageClientServer.sendMessageToOne(content,userId,getId);
                                    System.out.println("私聊消息");
                                    break;
                                case "4":
                                    System.out.println("请输入你想发送的文件的用户：");
                                    getId = Utility.readString(50);
                                    System.out.println("请输入发送文件的路径(形式：d:\\xx.jpg：");
                                    String src = Utility.readString(100);
                                    System.out.println("请输入把文件发送给对方的路径：");
                                    String dest = Utility.readString(100);
                                    FileClientService.sendFileToOne(src,dest,userId,getId);

                                case "9":
                                    //调用方法 给服务端发送一个退出系统的message对象
                                    UserClientServer.layout();
                                    loop = false;
                                    break;
                            }
                        }
                    }else { //登入服务器失败 不存在账户 获者密码错误
                        System.out.println("===========登入失败=============");
                    }
                    break;
                case "9":
                    loop = false;
                    System.out.println("退出系统");
                    break;
            }
        }
    }
}
