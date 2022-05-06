package day09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author hongtao
 * @create 2022-04-20-13:59
 */
@SuppressWarnings("all")
public class HashGenericTest {
    public static void main(String[] args) {
        HashMap<String,Student> map = new HashMap<String,Student>();
        map.put("七七",new Student("七七",21));
        map.put("小七",new Student("小七",19));
        //迭代器 EntrySet
        Set<Map.Entry<String, Student>> entries = map.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Student> value = iterator.next();
            System.out.println(value.getKey()+"-"+value.getValue());
        }

    }
}
class Student{
    private String name ;
    private int age;
    public Student(){}
    public Student(String name,int age){
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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}