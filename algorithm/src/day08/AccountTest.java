package day08;

public class AccountTest {
    public static void main(String[] args) {
        Account a1 = new Account();
        Account a2 = new Account("123456",3000);
        Account.setInterestRate(0.012);
        Account.setMinMoney(100);
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a1.getInterestRate());
    }
}

