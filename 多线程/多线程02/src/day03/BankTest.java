package day03;

/**
 * @author hongtao
 * @create 2022-04-07-13:23
 */

public class BankTest {
}

class Bank{
    private Bank(){}
    private  static  Bank instance = null;

    public static synchronized Bank getInstance(){
        //方式一 效率稍微差
//        synchronized (day03.Bank.class) {
//            if (instance ==null){
//                instance = new day03.Bank();
//            }
//            return instance;
//        }
        //方式二  效率稍高
        if(instance==null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
