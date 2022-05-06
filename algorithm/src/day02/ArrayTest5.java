package day02;

public class ArrayTest5 {
    public static void main(String[] args) {
        String[] arr = new String[]{"JJ","DD","MM","GG"};
        String[] arr1 = new String[arr.length];
        //数组的复制
        for (int i =0;i<arr.length;i++){
            arr1[i] = arr[i];
        }
        //数组的反转
        for (int i =0 ;i< arr1.length/2;i++){
            String temp = arr1[i];
            arr1[i] = arr1[arr1.length-i-1];
            arr1[arr1.length-i-1] = temp;
        }
        //遍历
        for (int i =0 ; i< arr1.length;i++ ){
            System.out.println(arr1[i]);
        }
        String dest = "DD";
        boolean isFlag =true;
        for (int i =0;i<arr.length;i++){
            if (dest.equals(arr[i])){
                System.out.println("找到了指定元素，位置为："+i);
                isFlag = false;
                break;
            }
        }
        if (isFlag) {
            System.out.println("没找到");
        }
    }
}
