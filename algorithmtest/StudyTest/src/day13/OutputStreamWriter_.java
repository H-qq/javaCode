package day13;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author hongtao
 * @create 2022-04-24-16:02
 */

public class OutputStreamWriter_ {
    public static void main(String[] args) throws Exception{
        String path = "d:\\hap.txt";
        String charSet = "utf8";
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),charSet));
        bfw.write("你真的牛");
        bfw.close();
        System.out.println(bfw);
    }
}
