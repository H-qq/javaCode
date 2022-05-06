package com.ht.reflection.class_;

import com.ht.reflection.Car;

/**
 * @author hongtao
 * @create 2022-05-05-10:36
 * 获取Class对象
 */

public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        //1 . class.forName
        String classAllPath = "com.ht.reflection.Car";
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);
        //2. 类名.class 应用场景：用于参数传递
        Class cls2 = Car.class;
        System.out.println(cls2);

        //3.对象.getClass（）：应用场景 有对象实例
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        //4,通过类加载器来获取Class对象
        //1)得到类加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        //2)通过类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

    }
}
