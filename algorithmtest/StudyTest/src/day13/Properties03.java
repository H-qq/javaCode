package day13;

import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author hongtao
 * @create 2022-04-24-16:43
 */

public class Properties03 {
    public static void main(String[] args) throws  Exception{
        //使用Properties创建配置文件，修改配置文件内容
        Properties properties = new Properties();
        //创建
        properties.setProperty("charset","utf-8");
        properties.setProperty("user","汤姆");
        properties.setProperty("pwd","123123");

        //将key-value存储到文件
        properties.store(new FileOutputStream("mysql.Properties"),null);
        //null :代表注释
    }
}
