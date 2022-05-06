package api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author hongtao
 * @create 2022-04-26-19:07
 */
//演示 InetAddress 类的使用
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //1、获取本机的InetAddress
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //2、根据指定主机名 获取InetAddress对象
        InetAddress name = InetAddress.getByName("LAPTOP-IS3IH8E0");
        System.out.println(name);

        //3、根据域名返回InetAddress对象，比如www.baidu.com 对应的InetAddress对象
        InetAddress name1 = InetAddress.getByName("www.baidu.com");
        System.out.println(name1);

        //4、通过 InetAddress 对象 获取相应地址
        String hostAddress = name1.getHostAddress();
        System.out.println(hostAddress);

        //5、通过InetAddress对象，获得对应的主机名、获这域名
        String hostName = name1.getHostName();
        System.out.println(hostName);
    }
}
