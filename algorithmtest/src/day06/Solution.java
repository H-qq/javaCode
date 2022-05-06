package day06;

import java.util.Arrays;

/**
 * @author hongtao
 * @create 2022-04-21-23:21
 * 原地删除 有序数组 中 是每一个数字只出现一次
 */

public class Solution {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,2,4,5,5};
        int n = removeNum(num);
        int[] arr = new int[n];
        System.out.println(n);
        for (int i = 0;i<n;i++){
            arr[i] = num[i];
        }
        System.out.println(Arrays.toString(arr));
    }
    public static int removeNum(int[] num){
        int left = 0;
        for(int right = 1;right<num.length;right++){
            if (num[left]!=num[right]){
                num[++left] = num[right];
            }
        }
        return ++left;
    }
}
