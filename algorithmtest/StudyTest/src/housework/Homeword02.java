package housework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author hongtao
 * @create 2022-04-24-17:15
 * <p>
 * 使用BufferedReader读取文本文件  为每行加上行号，
 */

public class Homeword02 {
    public static void main(String[] args) {
        String path = "d:\\mytemp\\hello.txt";
        BufferedReader br = null;
        String line = null;
        int lineNum = 0;
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                System.out.println(++lineNum+":"+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
