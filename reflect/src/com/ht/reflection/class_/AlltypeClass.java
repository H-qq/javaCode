package com.ht.reflection.class_;

import java.io.Serializable;

/**
 * @author hongtao
 * @create 2022-05-05-11:07
 * 演示哪些类型有Class对象
 *
 */

public class AlltypeClass {
    public static void main(String[] args) {
        Class<String> cls1 = String.class;
        Class<Serializable> cls2 = Serializable.class;
        Class<Integer> cls3 = Integer.class;
        Class<Integer[][]> cls4 = Integer[][].class;
        Class<Deprecated> cls5 = Deprecated.class;
        Class<Thread.State> cls6 = Thread.State.class;
        Class<Long> longClass = long.class;
        Class<Void> voidClass = void.class;
        Class<Class> classClass = Class.class;
    }
}
