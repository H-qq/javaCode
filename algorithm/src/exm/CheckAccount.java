package exm;

public class CheckAccount extends Account{
    private double overdraft;
    public CheckAccount(){}

    public CheckAccount(int id,double balance,double annuallnteresRate,double overdraft){
        super(id,balance,annuallnteresRate);
        this.overdraft = overdraft;
    }
    public void toSring(){
        System.out.println(super.toString()+"，额度剩余："+overdraft);
    }
    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public void withdraw(double amount){
        if (amount < this.getBalance()){
            super.withdraw(amount);
        }else if (amount > this.getBalance()){
            if (amount < this.getBalance()+overdraft){
                overdraft =overdraft - (amount-this.getBalance());
                setBalance(0);
                System.out.println("您的账户余额："+this.getBalance());
                System.out.println("您的透支余额剩余："+overdraft);
            }else{
                System.out.println("您的透支余额不足");
            }
        }
    }
}
