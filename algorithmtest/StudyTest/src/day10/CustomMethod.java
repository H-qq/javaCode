package day10;

import java.util.ArrayList;

/**
 * @author hongtao
 * @create 2022-04-21-13:40
 */

public class CustomMethod {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("宝马",100);
        Fish fish = new Fish();
        fish.hello(new ArrayList(),3.14f);
    }
}

class Car{
    public void run(){

    }
    //说明
    //1.<T,R>就是泛型
    //2.提供给fly使用
    public  <T,R> void fly(T t,R r){  //泛型方法
        System.out.println("t.getClass() = " + t.getClass());
        System.out.println("r.getClass() = " + r.getClass());

    }
}
class Fish<T,R>{
    public <U,M> void eat(U u,M m){

    }
    public<K> void hello(R r,K k){
        System.out.println(r.getClass());
        System.out.println(k.getClass());
    }
}