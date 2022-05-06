package server;

import java.util.HashMap;

/**
 * @author hongtao
 * @create 2022-04-28-22:53
 */

public class MangeClientConnectServerThread {
    //我们把多个线程放入HashMap 集合 ，key 就是id value就是 线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

    //将某一个下次加入到集合中
    public static void addClientConnectServerThread(String userId,ClientConnectServerThread clientConnectServerThread){
        hm.put(userId,clientConnectServerThread);
    }
    //通过一个方法调用  通过UserID 得到对应线程
    public static  ClientConnectServerThread getClientConnectServerThread(String userID){
        return hm.get(userID);
    }


}
