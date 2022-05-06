package day06;

/**
 * @author hongtao
 * @create 2022-04-15-17:49
 */

public class Person implements Comparable {
    private String name ;
    private int age;

    public Person() {
    }

    public Person(String name, int age)  {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        System.out.println("Personle类的equal方法");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person){
            Person p1 = (Person) o;
            return this.name.compareTo(p1.name);
        }else {
            throw new RuntimeException("输入类型不匹配");
        }
    }
    //    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + age;
//        return result;
//    }
}
