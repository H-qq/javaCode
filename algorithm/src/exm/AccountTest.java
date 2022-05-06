package exm;

public class AccountTest {
    public static void main(String[] args) {
        Account a1 = new Account(1122,20000.00,0.0045);
        a1.withdraw(30000);
        a1.withdraw(2500);
        a1.deposit(3000);
        System.out.println(a1.toString());
        CheckAccount a2 = new CheckAccount(1132,20000,0.0045,5000);
        a2.withdraw(5000);
        System.out.println("账户余额："+a2.getBalance()+"可透支金额："+a2.getOverdraft());
        a2.withdraw(18000);
        System.out.println("账户余额："+a2.getBalance()+"可透支金额："+a2.getOverdraft());
        a2.withdraw(3000);
        System.out.println("账户余额："+a2.getBalance()+"可透支金额："+a2.getOverdraft());
        a2.toSring();
    }
}
