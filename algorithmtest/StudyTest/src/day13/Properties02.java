package day13;

import java.io.FileReader;
import java.util.Properties;

/**
 * @author hongtao
 * @create 2022-04-24-16:38
 */

public class Properties02 {
    public static void main(String[] args)throws Exception{
        //使用Properties读取mysql。Properties
        //1.创建Properties类
        Properties properties = new Properties();
        //2.加载指定配置文件
        properties.load(new FileReader("mysql.Properties"));
        //3.把键值对显示到控制台
       // properties.list(System.out);
        //4.根据key获取对应值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println(user+pwd);
    }
}
