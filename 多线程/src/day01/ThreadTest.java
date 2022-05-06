package day01;

/**
 *
 * @author hongtao
 * @create 2022-04-04-14:34
 */
//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2.重写Thread类中的run方法
    public void run(){
        for (int i = 0;i<100;i++){
            if (i %2==0){
                System.out.println(i);
            }
        }
    }
}


public class ThreadTest {
    //3.创建子类对象
    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        //4.调用start（）
        t1.start();
    }
}
