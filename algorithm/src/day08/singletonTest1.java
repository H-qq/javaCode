package day08;

public class singletonTest1 {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
    }
}

//饿汉式：
class Bank{
    //1.私有化类的构造器
    private Bank(){

    }
    //2.内部创建类的对象  静态方法里只能调用静态
    private static Bank instance = new Bank();

    //3.提高公共的方法，返回了类的对象
    public static Bank getInstance(){
        return instance;
    }
}