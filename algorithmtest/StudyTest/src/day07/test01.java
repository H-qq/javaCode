package day07;

import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * @author hongtao
 * @create 2022-04-16-13:37
 */

public class test01 {
    @Test
    public void test6(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private static void updateList(List list) {
        list.remove(2);
    }

    @Test
    public void test5(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(123);System.out.println(list);
        //add
        list.add(1,"AA");
        System.out.println(list);
        // addAll
        List<Object> objects = Arrays.asList(1,2,3);
        list.addAll(objects);
        System.out.println(list.size());  //7

        //get
        System.out.println(list.get(1)); //AA

        //indexof  首次出现的位置 如果不存在 返回-1
        int index = list.indexOf(456);
        System.out.println(index);  //2
        //lastindexof  最后一次出现的位置
        int lastIndexOf = list.lastIndexOf(123);
        System.out.println(lastIndexOf);  //3

        //remove  删除元素
        Object obj = list.remove(0);
        System.out.println(obj); //123
        System.out.println(list);

        //set  设置 修改元素
        list.set(0,"BB");
        System.out.println(list);

        //sublist  获取左闭右开的子集合  本身不变化
        List list1 = list.subList(2, 4);
        System.out.println(list1);
        //方式一  迭代器
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("*****************");
        //方式二 foreach
        for (Object OBJ : list){
            System.out.println(OBJ);
        }

        System.out.println("***********");
        //方式三 ：普通循环
        for (int i =0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    @Test
    public void test4(){

    }
    @Test
    public void test3(){
        String[] arr = new String[]{"MM","MM","MM","MM"};
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//        }
        for(String s : arr){
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(false);
        String[] res = new String[]{"123","123dawd ","2DAD"};
        //for(集合元素的类型 obj时局部对象 ： 集合对象）
        for(Object obj:coll){
            System.out.println(obj);
        }
        for(String s:res){
            System.out.println(s);
        }
    }
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(false);
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if (obj.equals(123)){
                iterator.remove();
            }
        }
        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
