package exm;

public class Account {
    private int id;
    private double balance;
    private double annuallnteresRate;

    public Account(){}
    public Account(int id,double balance,double annuallnteresRate){
        this.annuallnteresRate = annuallnteresRate;
        this.balance = balance;
        this.id = id;
    }
    public void withdraw(double amount){
        if (balance>amount){
            balance-=amount;
            System.out.println("您的账户余额为："+balance);
        }else {
            System.out.println("余额不足！");
            System.out.println("你的账户余额为："+balance);
        }
    }
    public void deposit(double anount){
        balance += anount;
        System.out.println("成功存入："+anount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annuallnteresRate=" + annuallnteresRate +
                '}';
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

    public double getAnnuallnteresRate() {
        return annuallnteresRate;
    }

    public void setAnnuallnteresRate(double annuallnteresRate) {
        this.annuallnteresRate = annuallnteresRate;
    }
}
