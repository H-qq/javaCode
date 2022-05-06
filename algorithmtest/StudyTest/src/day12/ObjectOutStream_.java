package day12;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author hongtao
 * @create 2022-04-23-16:17
 */
//完成数据序列化
public class ObjectOutStream_ {
    public static void main(String[] args) throws Exception {
        // 序列化后没保存的文件格式，不是纯文本，而是按照自己的格式
        String path = "d:\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        //序列化数据到 d：\\data.dat
        oos.writeInt(100); //int --> Integer (实现了 Serializable)
        oos.writeBoolean(true);//bollen -->Boolean (实现了 Serializable)
        oos.writeChar('a'); //char --> Character (实现了 Serializable)
        oos.writeDouble(9.5);//double -->Double (实现了 Serializable)
        oos.writeUTF("好牛");//String  (实现了 Serializable)
        //保存一个dog 对象
        oos.writeObject(new Dog("旺财", 4));

        oos.close();
        System.out.println("数据保存完毕（序列化形式）");


    }
}

//如果需要序列化 某一个类对象，实现 Serializable
class Dog implements Serializable {
    private String name;
    private int age;

    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}