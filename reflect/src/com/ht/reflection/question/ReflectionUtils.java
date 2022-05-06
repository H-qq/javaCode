package com.ht.reflection.question;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author hongtao
 * @create 2022-05-05-14:54
 *
 * 如何通过反射获取类的结构信息
 */

public class ReflectionUtils {
    public static void main(String[] args) {

    }
    //第二组
    @Test
    public void test2() throws ClassNotFoundException{
        Class<?> PersonCls = Class.forName("com.ht.reflection.question.Person");
        Field[] declaredFields = PersonCls.getDeclaredFields();
        //getModifiers（）；默认修饰符 是 0，public 是 1，private 是2 ，protected 是4,static是8，final 是16
        //getType() 该属性的类型
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName()+"该属性的修饰符值："
                    +declaredField.getModifiers()+"该属性的类型"+declaredField.getType());
        }
        //输出当前方法的形参数组情况  parameterType()

        Constructor<?>[] declaredConstructors = PersonCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("===============");
            System.out.println(declaredConstructor.getName());
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("类型："+parameterType);
            }
        }


    }

    //第一组API
    @Test
    public void test1() throws ClassNotFoundException {
        //得到class对象
        Class<?> pensonCls = Class.forName("com.ht.reflection.question.Person");
        //getName 获取全类名
        System.out.println(pensonCls.getName());
        //getSimpleName 获取简单类名
        System.out.println(pensonCls.getSimpleName());
        //getFields 获取public修饰的属性，包含本类以及父类 ---只能public
        Field[] fields = pensonCls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        //获得getDeclaredFields ：获取本类所有属性
        Field[] declaredFields = pensonCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        //getMethods：获取所有public修饰所有的方法 包括父类以及子类
        Method[] methods = pensonCls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        //getDeclaredMethods 获取本类所有方法
        Method[] declaredMethods = pensonCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        //getConstructors:获取所有public修饰的构造器，包括本类以及父类
        Constructor<?>[] constructors = pensonCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
        //getDeclaredConstructors :获取本类所有的构造器
        Constructor<?>[] declaredConstructors = pensonCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }
        //getPackage():获取包名
        System.out.println(pensonCls.getPackage());
        //getSuperClass：以Class形式返回父类信息
        Class<?> superclass = pensonCls.getSuperclass();
        System.out.println(superclass);
        //getInterfaces:以Class【】形式返回接口信息
        Class<?>[] interfaces = pensonCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }

}
interface IA{

}
interface IB{

}
class  A{
    public String hobby;
}
class Person extends  A implements IA,IB{
    //属性
    public String name;
    protected int age;
    String job;
    private double sal;

    //构造器
    public Person(){

    }
    public Person(String name){
        this.name = name;
    }

    public Person(String name, int age, String job, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.sal = sal;
    }

    private Person(int age){
        this.age = age;
    }
    //f方法
    public void m1(){

    }

    protected void m2(){

    }

    void m3(){

    }
}