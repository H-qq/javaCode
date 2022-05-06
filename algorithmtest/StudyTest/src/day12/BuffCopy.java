package day12;

import java.io.*;

/**
 * @author hongtao
 * @create 2022-04-23-14:50
 */

public class BuffCopy {
    public static void main(String[] args) {
        String path = "d:\\news001.txt";
        String destFilePath = "d:\\IOTest\\news001.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(path));
            bw = new BufferedWriter(new FileWriter(destFilePath));

            //读取
            while ((line = br.readLine()) != null) {
                //每读取一行就写入
                bw.write(line);
                //换行
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null && bw != null) {
                    br.close();
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
