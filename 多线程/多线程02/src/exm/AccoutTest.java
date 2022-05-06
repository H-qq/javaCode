package exm;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 * 分析 ：是否是线程问题？是
 *      是否共享数据： 是
 *      是否存在线程安全问题 ： 有
 * @author hongtao
 * @create 2022-04-08-16:25
 */
class Account{
    private double balance;
    private static ReentrantLock lock = new ReentrantLock();
    public Account(double balance){
        this.balance = balance;
    }
    //存钱
    public void deposit(double amt){
        lock.lock();
        try {
            if (amt>0){
                balance += amt;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":存钱成功，余额为："+balance);
            }
        } finally {
            lock.unlock();
        }
    }
}
class Customer extends Thread{
    private Account acct;
    public Customer(Account acct) {
        this.acct = acct;
    }
    public void run(){
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}
public class AccoutTest {
    public static void main(String[] args) {
        Account acct = new Account(3000);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }
}
