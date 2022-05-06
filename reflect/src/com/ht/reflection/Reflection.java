package com.ht.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author hongtao
 * @create 2022-05-04-17:43
 */

public class Reflection {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();

        Class aClass = Class.forName(classfullpath);
        Object o = aClass.newInstance();
        Method method1 = aClass.getMethod(method);
        method1.invoke(o);

        Field name = aClass.getField("age"); //getField 不能得到私有属性
        System.out.println(name.get(o));//传统写法 对象.成员变量 反射：成员变量对象.get(对象）

        Constructor constructor = aClass.getConstructor();//可以指定参数类型,空的则为无参
        System.out.println(constructor);

        Constructor constructor1 = aClass.getConstructor(String.class);//传入String 的对象
        System.out.println(constructor1);
    }
}
