package day13;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author hongtao
 * @create 2022-04-24-16:25
 */

public class Properties01 {
    public static void main(String[] args) throws Exception{
        //读取mysql.Properties 文件，并获取得到相应的信息
        BufferedReader bufferedReader = new BufferedReader(new FileReader("mysql.Properties"));
        String line = "";
        while ((line= bufferedReader.readLine()) != null) {
            String[] split = line.split("=");
          //  System.out.println(split[0]+"值:"+split[1]);
            //如果要求指定要求只要ip值
            if ("ip".equals(split[0])){
                System.out.println(split[1]);
            }
        }
        bufferedReader.close();
    }
}
