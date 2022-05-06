package com.ht.reflection.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hongtao
 * @create 2022-05-05-16:51
 */

public class homewokr2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("java.io.File");
        //得到所有所有的构造器
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        //遍历输出
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        //3.通过newInstance 创建file对象
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        String filePath = "d:\\mynew.txt";
        Object file = declaredConstructor.newInstance(filePath);
        //得到方法对象
        Method createNewFile = aClass.getMethod("createNewFile");
        createNewFile.invoke(file);

        //file 运行类型已经时File
        System.out.println(file.getClass());

        System.out.println("创建成功");


    }
}
