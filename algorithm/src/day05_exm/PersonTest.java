package day05_exm;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(20);
        System.out.println(p1.getAge());
    }
}

class Person{
    private String name;
    private int age;

    public  void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}
