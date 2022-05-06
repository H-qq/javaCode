package day08;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author hongtao
 * @create 2022-04-18-15:47
 */

public class MapTest {
    @Test
    public void test5(){
        //遍历
        Map map  = new HashMap();
        //添加
        map.put("AA",123);
        map.put("BB",456);
        map.put("CC",789);
        //遍历key
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有Value
        for (Object value : map.values()) {
            System.out.println(value);
        }

        //遍历所有 Key-value
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey()+"-->"+entry.getValue());
        }
    }
    @Test
    public void test4(){
        Map map  = new HashMap();
        //添加
        map.put("AA",123);
        map.put("BB",456);
        map.put("CC",789);

        System.out.println(map.get("AA"));
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);
        isExist = map.containsKey(123);
        System.out.println("isExist = " + isExist);

        map.clear();
        System.out.println(map.isEmpty());


    }
    @Test
    public void test3(){
        //添加、修改、删除
        Map map  = new HashMap();
        //添加
        map.put("AA",123);
        map.put("BB",456);
        map.put("CC",789);
        //修改
        map.put("AA",12);
        System.out.println(map);
        Map map1 = new HashMap();
        map1.put("DD",123);
        map1.put("EE",123);
        map.putAll(map1);
        System.out.println(map);

        //移除 remove
        Object value = map.remove("CC");
        System.out.println(value);

        //clear
        map.clear();//与Map = null 不同
        System.out.println(map.size());

    }
    @Test
    public void test2(){
        Map map = new HashMap();
        map.put(123,"aaa");
        map.put(456,"bb");
        map.put(12,"cc");
    }
    @Test
    public void test1(){
        Map sm = new HashMap();
        sm.put(null,123);

    }
}
