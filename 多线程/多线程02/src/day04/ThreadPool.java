package day04;

import java.lang.reflect.Executable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池
 * @author hongtao
 * @create 2022-04-08-18:05
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            if (i %2 ==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            if (i %2 !=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new NumberThread());//适合使用Runnable
        service.execute(new NumberThread1());
//        service.submit();//适合适用于Callable
        service.shutdown();

    }
}
