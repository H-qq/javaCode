package SORT;

public class QuickS {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,4,6,2,12,2};
        sort(arr,0, arr.length-1);
        for (int i = 0;i<arr.length;i++){
            System.out.println(","+arr[i]);
        }
    }
    public static void sort(int[] arr,int lindex,int rindex){
        if (lindex>=rindex){
            return;
        }
        //这句话是为了之后第二轮之后 找不到第一个的位置 和 最后的位置
        int l = lindex;
        int r = rindex;

        int x = arr[l];
        while (l<r){
            while (r>l&&arr[r]>x){
                r--;
            }
            arr[l] = arr[r];
            while (l<r &&arr[l]<=x){
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = x;
        //递归
        sort(arr,lindex,l-1);
        sort(arr,r+1, rindex);
    }
}
