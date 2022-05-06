package com.ht.reflection.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hongtao
 * @create 2022-05-05-16:40
 */

public class homework1 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
      //  Class<?> aClass = Class.forName("com.ht.reflection.homework.PrivateTest");
        //或者
        Class<PrivateTest> privateTestClass = PrivateTest.class;
        //创建对象实例
        PrivateTest privateTest = privateTestClass.newInstance();

        //修改name属性
        Field name = privateTestClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(privateTest,"小七");

        Method getName = privateTestClass.getDeclaredMethod("getName");
        System.out.println(getName.invoke(privateTest));
    }
}
class PrivateTest{
    private String name  = "hellokitty";
    public String getName(){
        return name;
    }
}