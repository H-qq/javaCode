package SORT;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        //1.boolean equals(int[] a,int[] b)
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,2,4,3};
        boolean isEqulas = Arrays.equals(arr1,arr2);
        System.out.println(isEqulas);
        //2.String toString(int[] a)
        System.out.println(Arrays.toString(arr1));
        //3.void fill(int[] a,int val)
        Arrays.fill(arr1,10);
        System.out.println(Arrays.toString(arr1));
        //4.void sort(int[] a)
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        //5.int binarySearch(int[] a,int key)
        int[] arr = new int[]{1,4,7,8,9,43,68,98};
        int index= Arrays.binarySearch(arr,7);
        System.out.println(index);
    }
}
