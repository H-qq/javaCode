package day02;

public class ArrayTest3 {
    public static void main(String[] args) {
        int [] array = new int[6];
        for (int i = 0;i < array.length;i++){
            array[i] = (int)(Math.random()*30)+1;
            for (int j =0;j<i;j++){
                if (array[j] == array[i]){
                    i--;
                    break;
                }
            }
        }
        for(int i =0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
