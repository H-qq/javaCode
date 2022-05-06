package SORT;

import java.util.Arrays;
//  插序法
public class test2 {
    public static void inserp(int arr[]){
        if (arr == null && arr.length<2){
            return;
        }
        for(int i =1 ;i<arr.length;i++){
            for (int j = i-1;j>=0&&arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
    }
    public static void swap(int arr[],int i,int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 64, 75, 2, 42, 6};
        inserp(arr);
        System.out.print(Arrays.toString(arr));
    }
}

