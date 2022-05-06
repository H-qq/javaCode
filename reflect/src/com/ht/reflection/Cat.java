package com.ht.reflection;

/**
 * @author hongtao
 * @create 2022-05-04-16:58
 */

public class Cat {
    private String name = "招财猫";
    public int age = 11;
    public void hi(){
        System.out.println("hi"+name);
    }
    public Cat(String name){
        this.name = name;
    }
    public Cat() {
    }

}
