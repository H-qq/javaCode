package day08;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hongtao
 * @create 2022-04-19-16:22
 */

public class CollectionTest {
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(34);
        list.add(167);
        list.add(1763);
        list.add(0);
        System.out.println(list);
        //随机
     //   Collections.shuffle(list);
        //排序
    //    Collections.sort(list);
        //交换
    //    Collections.swap(list,2,3);
        //某数据出现了几次
    //    System.out.println("Collections.frequency(list,123) = " + Collections.frequency(list, 123));

        // System.out.println(list);
        //线程安全的
        List list1 = Collections.synchronizedList(list);
        System.out.println(list1);
    }
}
