package day04;

public class ValueTransferTest {
    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        System.out.println("m:" + m + ",n:" + n);
        ValueTransferTest sw1 = new ValueTransferTest();
        sw1.swap(m,n);
    }
    public void swap(int m ,int n){
        int temp = n;
        n = m;
        m = temp;
        System.out.println("m:" + m + ",n:" + n);
    }
}