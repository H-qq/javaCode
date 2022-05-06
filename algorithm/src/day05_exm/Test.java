package day05_exm;

public class Test {
    public static void main(String[] args) {
        Boy boy = new Boy("涛涛",21);
        boy.shout();

        Girl girl = new Girl("七七",21);
        girl.marry(boy);

        Girl girl1 = new Girl("祝英台",19);
        int compare = girl.compare(girl1);
        if (compare>0){
            System.out.println(girl.getName());
        }else if (compare<0){
            System.out.println(girl1.getName());
        }else {
            System.out.println("一样大");
        }
    }
}

class Boy{
    private String name;
    private int age;
    public void marry(Girl girl){
        System.out.println("我想娶"+girl.getName());
    }

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void shout(){
        if (this.age >= 22){
            System.out.println("你可以合法登记结婚");
        }else {
            System.out.println("不能结婚");
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Girl{
    private String name;
    private int age;
    public Girl(){}
    public Girl(String name,int age){
        this.age = age;
        this.name = name;
    }
    public void marry(Boy boy){
        System.out.println("我想嫁给"+boy.getName());
        boy.marry(this);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //比较两个对象大小
    public int compare(Girl girl){
        if (this.age>girl.age){
            return 1;
        }else if (this.age< girl.age){
            return -1;
        }else {
            return 0;
        }
    }
}