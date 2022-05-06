package day05_exm;

public class Test1 {
    public static void main(String[] args) {
        Customer c1 = new Customer("Jane","Simith");
        Account a1 = new Account(1000,2000,0.0123);
        c1.setAccount(a1);
        a1.deposit(100);
        a1.withDraw(960);
        a1.withDraw(2000);
        System.out.println(a1.toString());
    }
}

class Account{
    private int id;
    private double balance;
    private double annuallinterestRate;
    public Account(){}
    public Account(int id,double balance,double annuallinterestRate){
        this.id  = id;
        this.annuallinterestRate = annuallinterestRate;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annuallinterestRate=" + annuallinterestRate +
                '}';
    }

    public void withDraw(double amount){
        if (amount>this.getBalance()){
            System.out.println("余额不足，取款失败");
        }else {
            this.balance = this.balance-amount;
            System.out.println("成功取出："+amount);
        }
    }
    public void  deposit(double amouunt){
        this.balance+=amouunt;
        System.out.println("成功存入"+amouunt);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallinterestRate() {
        return annuallinterestRate;
    }

    public void setAnnuallinterestRate(double annuallinterestRate) {
        this.annuallinterestRate = annuallinterestRate;
    }
}

class Customer{
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(){}
    public Customer(String f,String l){
        firstName = f;
        lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}