package day02;

public class ArrayTest4 {
    public static void main(String[] args) {
        int[] arr= new int[10];

        for (int i =0 ;i<arr.length;i++){
            arr[i] = (int)(Math.random()*(99-10+1)+10);
        }
        //求最大值
        int maxValue = arr[0];
        for (int i = 0;i<arr.length;i++){
            if (maxValue < arr[i]){
                maxValue = arr[i];
            }
        }
        System.out.println("最大值："+maxValue);
        //最小值‘
        int minValue = arr[0];
        for (int i = 0;i<arr.length;i++){
            if (maxValue > arr[i]){
                maxValue = arr[i];
            }
        }
        System.out.println("最小值："+minValue);
        int sum= 0;
        for (int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        System.out.println("总和为："+sum);
        int avgValue = sum/arr.length;
        System.out.println("平均数："+avgValue);
    }
}
