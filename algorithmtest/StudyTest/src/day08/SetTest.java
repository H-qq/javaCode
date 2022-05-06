package day08;

import day06.Person;
import org.junit.Test;

import java.util.*;

/**
 * @author hongtao
 * @create 2022-04-17-17:33
 */

public class SetTest {
    @Test
    public void test4(){
        Comparator com = new Comparator() {
            //按照年龄从小到大的排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                }else {
                    throw new RuntimeException("输入类型不匹配");
                }
            }
        };
        TreeSet treeSet = new TreeSet();
//        treeSet.add(123);
//        treeSet.add(43);
//        treeSet.add(-232);
        treeSet.add(new Person("Tom",23));
        treeSet.add(new Person("Tam",23));
        treeSet.add(new Person("Jam",24));
        treeSet.add(new Person("Ami",21));
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test3(){
        TreeSet treeSet = new TreeSet();
//        treeSet.add(123);
//        treeSet.add(43);
//        treeSet.add(-232);
        treeSet.add(new Person("Tom",23));
        treeSet.add(new Person("Tam",23));
        treeSet.add(new Person("Jam",24));
        treeSet.add(new Person("Ami",21));
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add(new Person("Tom",12));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add(new Person("Tom",12));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
