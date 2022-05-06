package day03;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hongtao
 * @create 2022-04-08-16:08
 */

public class LockTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Thread t1 = new Thread(w1);
        Thread t3 = new Thread(w1);
        Thread t2 = new Thread(w1);
        t1.start();
        t2.start();
        t3.start();
    }
}

class  Window implements Runnable{
    private int ticket = 100;
    //1.实例化 ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);
    public void run(){
        while (true){
            try {
                //2.调用lock方法
                lock.lock();
                if (ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":售票，票号为："+ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                //调用解锁的方法 unlock
                lock.unlock();
            }

        }
    }
}
