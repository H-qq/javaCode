package day09;

public class EmployeeTest {
    public static void main(String[] args) {
        Manager manager = new Manager("库克",1001,5000,50000);
        //多态的使用
        Employee manager1 = new Manager();

        Employee work = new CpmmonEmployee();
        work.work();
        manager.work();
    }
}
