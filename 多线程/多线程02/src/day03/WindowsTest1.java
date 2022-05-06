package day03;

/**
 * @author hongtao
 * @create 2022-04-06-16:46
 */
class MThread implements Runnable{
    private static  int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    private static synchronized void show(){

        if (ticket > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：卖票，票号为" + ticket);
            ticket--;
        }
    }
}
public class WindowsTest1 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MThread m1 = new MThread();
        //4.将此对象作为参数传递到Thread的构造器中，创建Thread类的对象
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);
        Thread t3 = new Thread(m1);
        //调用start
        t1.start();
        t2.start();
        t3.start();
    }
}
