package day04;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hongtao
 * @create 2022-04-13-13:19
 */

public class CompareTest {
    @Test
    public void test4(){
        GoodsTest[] arr = new GoodsTest[6];
        arr[0] = new GoodsTest("lenoMouse",34);
        arr[1] = new GoodsTest("dellMouse",43);
        arr[2] = new GoodsTest("xiaomiMouse",12);
        arr[3] = new GoodsTest("huaweiMouse",65);
        arr[4] = new GoodsTest("microsoMouse",43);
        arr[5] = new GoodsTest("microsoMouse",79);


        Arrays.sort(arr, new Comparator() {
            @Override
            //先按产品名称 从低到高 然后再价格从高到底
            public int compare(Object o1, Object  o2) {
                if (o1 instanceof GoodsTest && o2 instanceof GoodsTest){
                    GoodsTest g1= (GoodsTest) o1;
                    GoodsTest g2 = (GoodsTest) o2;
                    if (g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else {
                        return  g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","MM","GG","JJ","DD","CC"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    //从小到大排列
                    return s1.compareTo(s2);
                }
                throw new RuntimeException("输入类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2(){
        GoodsTest[] arr = new GoodsTest[5];
        arr[0] = new GoodsTest("lenoMouse",34);
        arr[1] = new GoodsTest("dellMouse",43);
        arr[2] = new GoodsTest("xiaomiMouse",12);
        arr[3] = new GoodsTest("huaweiMouse",65);
        arr[4] = new GoodsTest("microsoMouse",43);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","MM","GG","JJ","DD","CC"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
