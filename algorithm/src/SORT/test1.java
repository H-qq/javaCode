package SORT;

import java.util.Arrays;
//选择排序
public class test1 {
    public static void choose(int arr[]){
        if (arr==null || arr.length<2){
            return;
        }
        int i = 0;
        for(i=0;i<arr.length-1;i++){
            int minnum = i;
            for (int j = i + 1;j<arr.length;j++){
                minnum  = arr[j]<arr[minnum] ? j:minnum;
            }
            swap(arr,i,minnum);
        }
    }
    public static void swap(int[]arr,int i,int j){
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,23,56,12,67};
        choose(arr);
        System.out.print(Arrays.toString(arr));
    }
}
