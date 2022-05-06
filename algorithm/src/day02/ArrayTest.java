package day02;

public class ArrayTest {
    public static void main(String[] args) {
        int num;
        num = 10;
        int id = 1001;

        int[] ids ;
        // 1.1 静态初始化  数组的初始化和数组元素的赋值操作同时进行
        ids = new int[]{1001,1002,1003,1004};
        // 2.2 动态初始化  数组的初始化和数组元素的赋值分开进行
        String [] names = new String[5];
        //2. 如果调用数组的指定位置  通过角标方式 一直到数组的长度-1 结束
        names[0] = "小明";
        names[1] = "小七";
        names[2] = "小一";
        //3.如何获取数组的长度的属性 ： length
        System.out.println(names.length);
        //4.如何遍历数组元素
        for (int i = 0;i< names.length;i++){
            System.out.println(names[i]);
        }
    }
}
