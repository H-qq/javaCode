package day05;

/**
 * @author hongtao
 * @create 2022-04-14-16:13
 */

public class AnnotationTest {
    public static void main(String[] args) {

    }
}

@MyAnnotation(value = "hello")
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
    public void walk(){
        System.out.println("人走路");
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


class Student extends Person{
    @Override
    public void walk() {
        System.out.println("学生走路");
    }
}