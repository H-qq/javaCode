package day07;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author hongtao
 * @create 2022-04-25-11:31
 */

public class text1 {
    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
    @Test
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            list.add(m+i,nums2[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < m+n; i++) {
            nums1[i] = list.get(i);
        }
        System.out.println(Arrays.toString(nums1));
    }

}
