package housework;

import java.io.*;
import java.util.Properties;

/**
 * @author hongtao
 * @create 2022-04-24-17:30
 * <p>
 * <p>
 * 1)编写一个dog.properties
 * 2)编写一个dog类 创建一个dog对象 读取dog.properties相应内容被进行初始化
 * 3）将创建的Dog对象，序列化到文件dog.dat文件
 * 4）将dog.dat反序列化
 */

public class Homework03 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("dog.Properties"));
        String name = properties.get("name").toString();
        int age = Integer.parseInt(properties.get("age").toString());
        String color = properties.get("color").toString();
        System.out.println(name);
        System.out.println(age);
        Dog dog = new Dog(name, age, color);
        System.out.println("====================");
        System.out.println(dog);

        //将创建的Dog对象 序列化 dog.data
        String path = "d:\\dog.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(dog);
        objectOutputStream.close();
        System.out.println("序列化完成");
        Homework03.m1();
    }

    //在编写一个方法反序列化
    public static void m1() throws Exception {
        String path = "d:\\dog.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        Dog dog = (Dog) objectInputStream.readObject();
        System.out.println(dog);
        objectInputStream.close();
        System.out.println("反序列化完成");
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog() {
    }

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
