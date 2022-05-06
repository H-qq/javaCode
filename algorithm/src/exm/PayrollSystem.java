package exm;

import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入现在月份：");
        int month = scanner.nextInt();

        Employee[] emps = new Employee[2];

        emps[0] = new SalaryEmployee("小七",1002,new MyDate(2001,9,19),7800);
        emps[1] = new HourEmployee("小涛",2000,new MyDate(2000,10,20),18,90);

        for(int i= 0;i < emps.length;i++){
            System.out.println(emps[i]);
            double salary = emps[i].earning();
            if (month == emps[i].getBirthday().getMonth()){
                salary += 100;
            }
            System.out.println("月工资为："+salary);

        }

    }
}
