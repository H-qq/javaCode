package common;

/**
 * @author hongtao
 * @create 2022-04-28-21:42
 */

public interface MessageType {
    //在接口中定义一些常量   不同常量的值，表示不同的消息
    String MESSAGE_LOGIN_SUCCEED = "1";//表示登入成功
    String MESSAGE_LOGIN_FAIL = "2";//表示登入失败
    String MESSAGE_COMM_MES = "3"; //普通信息包
    String MESSAGE_GET_ONLINE_FRIEND = "4";//要求返回用户在线列表
    String MESSAGE_RET_ONLINE_FRIEND = "5"; //返回在线用户
    String MESSAGE_CLIENT_EXIT = "6";//客户端请求退出
    String MESSAGE_TO_ALL_MES = "7";//群发消息
    String MESSAGE_FILE_MES = "8";//文件消失

}
