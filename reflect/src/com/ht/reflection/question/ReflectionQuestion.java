package com.ht.reflection.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author hongtao
 * @create 2022-05-04-16:51
 */

public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();

        //使用反射机制
        //1）加载类 返回一个class 对象
        Class aClass = Class.forName(classfullpath);
        //2）通过aclass 得到你加载的类的对象实例
        Object o = aClass.newInstance();
        System.out.println(o.getClass());
        //3)通过aClass得到你加载的类
        //即在反射中，可以把方法视为对象
        Method method1 = aClass.getMethod(method);
        //4）通过method1 调用方法
        //即 通过方法对象来调用方法
        method1.invoke(o);//传统 对象.方法（） ， 反射机制  方法.invoke（对象）
    }
}
