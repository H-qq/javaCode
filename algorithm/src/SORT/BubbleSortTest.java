package SORT;


public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{45,24,44,13,46,34,67,34};
        //冒泡排序：比较的是相邻的两个
        for (int i =0 ;i<arr.length -1 ;i++){
            for (int j =0;j<arr.length -1-i;j++){
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            }
        for (int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
             }
        }
    }
