package exm;

public class SalaryEmployee extends Employee {
    private double monthSalary;

    public SalaryEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }
    public SalaryEmployee(String name, int number, MyDate birthday,double monthSalary) {
        super(name, number, birthday);
        this.monthSalary = monthSalary;
    }
    @Override
    public double earning() {
        return monthSalary;
    }
    public String toString(){
        return "SalaryEmployee["+super.toString()+"]";
    }

    public double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }
}
