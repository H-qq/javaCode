package day06;

import org.junit.Test;

import java.util.*;

/**
 * @author hongtao
 * @create 2022-04-15-14:25
 */

public class CollectionTest {
    @Test
    public void Test4(){
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        //1.hashCode：返回当前对象的哈希值
        System.out.println(coll1.hashCode());
        //2.集合转换成数组
        Object[] objects = coll1.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);

        }
        // 扩展：数组换成集合 调用 Arrays.asList（） 静态方法
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        //3.iterator：返回Iterator 接口的实例，用于遍历集合元素
        //使用迭代器接口
        //方式一
        Iterator iterator = coll1.iterator();
//        System.out.println(iterator.next());//123
//        System.out.println(iterator.next());//456
        //方式二 循环
//        for (int i = 0; i < coll1.size(); i++) {
//            System.out.println(iterator.next());
//        }
        //方式三： 推荐方式
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void Test3(){
        //1.remove()
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("jerry",20));
        coll1.add(new String("tomo"));
        coll1.remove(123);
        System.out.println(coll1);
        //2.removeAll 移除所有元素   相当于差集
        Collection coll2 = Arrays.asList(123,3456);
        coll1.removeAll(coll2);
        System.out.println(coll1);

        //3.交集   retain  返回的时交集结果

        //4.equal（Object object） 是要求按顺序 不同则false


    }
    @Test
    public void Test2(){
        Collection coll =  new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry",20));
        //contains(Object obj):判断当前集合是否含有Obj
        boolean contain = coll.contains(123);
        System.out.println(contain);
        System.out.println(coll.contains(new Person("jerry",20)));

        //containsAll(Collection coll):判断形参coll1所有的元素是否都存在当前集合中
        //相当于子集
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));

    }

    @Test
    public void Test1(){
        Collection coll = new ArrayList();
        Collection coll1 = new ArrayList();
        coll.add("AA");
        coll1.add(123);
        System.out.println(coll.size());
        coll.addAll(coll1);
        System.out.println(coll);
    }
}
