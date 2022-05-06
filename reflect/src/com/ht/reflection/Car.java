package com.ht.reflection;

/**
 * @author hongtao
 * @create 2022-05-04-22:13
 */

public class Car {
    public String brand ="宝马";
    public int price = 10;
    public String color = "red";

    @Override
    public String toString() {
        return "Car{" +
                "band='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
