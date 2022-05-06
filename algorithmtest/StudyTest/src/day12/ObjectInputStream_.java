package day12;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author hongtao
 * @create 2022-04-23-16:30
 */

public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        //指定反序列化文件
        String path = "d:\\data.dat";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));

        //读取顺序
        //1.读取（反序列）顺序需要和保存（序列化）顺序一致 否则抛出异常
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object dog = ois.readObject();
        System.out.println(dog.getClass());  //底层Object 会自动 转 dog
        System.out.println(dog);
        //重要细节：
        /*如果我们希望调用dog方法 :需要进行向下转型
        Dog dog1 = (Dog)dog;
       dog1.getName();
         */
        Dog dog1 = (Dog) dog;
        System.out.println(dog1.getName());
        ois.close();
    }
}
