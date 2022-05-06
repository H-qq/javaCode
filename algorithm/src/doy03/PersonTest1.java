package doy03;

public class PersonTest1 {
    public static void main(String[] args) {
        Person1 p1 = new Person1();
        p1.name = "Tom";
        p1.age = 18;
        p1.sex= "男";

        p1.study();
        p1.showAge();
        int newAge = p1.addAge(2);
        System.out.println("新年龄为："+newAge);
        System.out.println(p1.age);

    }
}
class Person1{
    String name ;
    int age;
    String sex;
    public void study(){
        System.out.println("Studying");
    }
    public void showAge(){
        System.out.println("age："+age);
    }
    public int addAge(int i){
        age+=i;
        return age;
    }
}
