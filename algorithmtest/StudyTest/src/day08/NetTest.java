package day08;
import java.net.*;
import java.util.Arrays;

/**
 * @author hongtao
 * @create 2022-04-17-20:05
 */

public class NetTest {
    public static void main(String[] args) throws Exception{
        //获取主机
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost = " + localHost.getHostName()); //主机名
        System.out.println("localHost.getAddress() = " +localHost.getHostAddress());//主机地址
        //获取域名ip地址
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println("ip2.getHostName() = " + ip2.getHostName());
        System.out.println("ip2.getHostAddress() = " + ip2.getHostAddress());
        //判断是否ping通
        System.out.println("ip2.isReachable(5000) = " + ip2.isReachable(5000));
    }
}
