package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author hongtao
 * @create 2022-04-20-16:39
 */
@SuppressWarnings("all")
public class Test1 {
    public static void main(String[] args){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("小七",3500,new MyDate(2001,9,19)));
        employees.add(new Employee("七七",5300,new MyDate(2000,10,20)));
        employees.add(new Employee("阿七",3600,new MyDate(2000,12,31)));
        employees.add(new Employee("小七",3600,new MyDate(2000,11,31)));
        employees.add(new Employee("傻七",3600,new MyDate(2000,12,31)));

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee p1 = (Employee) o1;
                    Employee p2 = (Employee) o2;
                    if (p1.getName().equals(p2.getName())) {
                        return -MyDate.compare(p1.getBirthday(), p2.getBirthday());
                    } else {
                        return -p1.getName().compareTo(p2.getName());
                    }
                } else {
                    throw new RuntimeException("输入类型不匹配");
                }
            }
        });
        System.out.println(employees);

    }
}

class Employee{
    private String name;
    private int sal;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}


class MyDate{
    private int month;
    private int day;
    private int year;

    public MyDate() {
    }

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static int compare(MyDate x,MyDate y) {
        if (x.year>y.year){
            return 1;
        }else if (x.year == y.year){
            if (x.month>y.month){
                return 1;
            }else if (x.month==y.month){
                if (x.day > y.day) {
                    return 1;
                }else if (x.day==y.day){
                    return 0;
                }else {
                    return -1;
                }
            }else {
                return -1;
            }
        }else {
            return -1;
        }
    }
}