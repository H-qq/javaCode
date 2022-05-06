package exm;

public class HourEmployee extends Employee{
    private int wege;//每小时工资
    private int hour;//月工作的小时数
    public HourEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }
    public HourEmployee(String name, int number, MyDate birthday,int wege,int hour) {
        super(name, number, birthday);
        this.wege = wege;
        this.hour = hour;
    }

    @Override
    public double earning() {
        return wege*hour;
    }
    public String toString(){
        return  "HourEmployee["+super.toString()+"]";
    }
}
