package day09;

/**
 * @author hongtao
 * @create 2022-04-20-13:42
 */

public class Generic03 {
    public static void main(String[] args) {
        Person<String> person = new Person<String>("泛型");
        Person<Integer> person1 = new Person<Integer>(100);
        person.t();
        person1.t();
    }
}
class Person<E>{
    E s;   //E 表示 s的数据累心，该数据在定义Person对象的时候指定，
    public Person(E s){
        this.s = s;
    }
    public E f(){  //返回类型使用E
        return s;
    }
    public void  t(){
        System.out.println(s.getClass());
    }
}
