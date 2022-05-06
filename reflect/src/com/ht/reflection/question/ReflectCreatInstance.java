package com.ht.reflection.question;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hongtao
 * @create 2022-05-05-16:03
 */

public class ReflectCreatInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //得到Student
        Class<?> aClass = Class.forName("com.ht.reflection.question.Student");
        //创建对象
        Object o = aClass.newInstance();
        //反射得到 age
        Field age = aClass.getField("age");
        age.set(o,88);
        System.out.println(o);
        //操作私有属性
        Field name = aClass.getDeclaredField("name");
        //进行暴破
        name.setAccessible(true);
        name.set(o,"小七");
        System.out.println(o);


    }
    @Test
    public void Test() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //方法调用
        Class<?> bossCls = Class.forName("com.ht.reflection.question.Boss");
        Object o = bossCls.newInstance();

        Method hi = bossCls.getMethod("hi",String.class);
        hi.invoke(o,"你好");

        //调用私有 static
        Method say = bossCls.getDeclaredMethod("say", int.class, String.class, char.class);
        //暴破
        say.setAccessible(true);
        System.out.println(say.invoke(o, 100, "张三", '男'));


    }
}



class Boss{
    public int age;
    private static String name;
    public Boss(){

    }
    private static String say(int n ,String s,char c){
        return n+" "+s+" "+c;
    }

    public void hi(String s){
        System.out.println("hi "+s);
    }
}
class Student{
    public int age;
    private static String name;
    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +",name="+name+
                '}';
    }
}
