package day09;

public class CpmmonEmployee extends Employee{
    private double bonus;
    public CpmmonEmployee(){
        super();
    }
    public CpmmonEmployee(String name,int id,double salary,double bonus){
        super(name,id,salary);
        this.bonus = bonus;
    }

    public void work(){
        System.out.println("员工工作");
    }
}
