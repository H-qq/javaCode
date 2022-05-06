package day09;

import java.util.ArrayList;

/**
 * @author hongtao
 * @create 2022-04-20-13:11
 */
@SuppressWarnings({"all"})

public class Generic {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("旺财",10));
        arrayList.add(new Dog("发财",1));
        arrayList.add(new Dog("小七",5));

        //遍历
        for (Object obj:arrayList){
            //向下转型
            Dog dog = (Dog) obj;
            System.out.println(((Dog) obj).getName()+"  "+((Dog) obj).getAge());
        }
    }

}
class Dog{
    private String name;
    private int age;
    public Dog(){}
    public Dog(String name,int age){
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
}

class Cat{
    private String name;
    private int age;
    public Cat(){}
    public Cat(String name,int age){
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
}
