package day09;

import java.util.ArrayList;

/**
 * @author hongtao
 * @create 2022-04-20-13:27
 */
@SuppressWarnings({"all"})
public class GenericImprove {
    public static void main(String[] args) {
        //传统方法解决 ==》 使用泛型
        //1.当我们ArrayList<Dog>表示存放到ArrrayList集合的元素是Dog类型
        //2.如果编译器发现其他类型，会报错
        //3.在遍历的时候，可以直接
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小七", 5));

        for(Dog dog : arrayList){
            System.out.println(dog.getName()+"  "+dog.getAge());
        }
 //       arrayList.add(new Cat("招财猫",21));

    }
}