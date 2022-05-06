package server.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author hongtao
 * @create 2022-04-28-23:46
 * 用于管理 和 客户端的线程
 */

public class ManageServerThread {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    //返回
    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //添加 线程对象 到hm
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }

    //根据userId返回线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }
    //这里编写一个方法 可以返回在线列表
    public static String getOnline(){
        //集合遍历 HashMap 的key
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()){
            onlineUserList += iterator.next().toString()+ " ";
        }
        return onlineUserList;
    }
    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }
}
