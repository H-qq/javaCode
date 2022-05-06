package com.ht.reflection.class_;

import com.ht.reflection.Car;

import java.lang.reflect.Field;

/**
 * @author hongtao
 * @create 2022-05-04-22:13
 */

public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllPath = "com.ht.reflection.Car";
        //获取到了Car类 对应的 Class 对象
        //<？>表示不确定java类型
        Class<?> cls = Class.forName(classAllPath);
        //1，输出class
        System.out.println(cls);//显示是哪一个类的Class对象
        //2.得到包名
        System.out.println(cls.getPackage().getName());
        //3.得到全类名
        System.out.println(cls.getName());
        //4.通过cls创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);//car.String

        //5.通过反射获取属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));

        //6.属性赋值
        brand.set(car, "奔驰");
        System.out.println(brand.get(car));
        //7.得到所有的属性
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());
            System.out.println(f);
        }
    }
}
