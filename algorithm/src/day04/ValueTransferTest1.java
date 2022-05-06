package day04;

import javax.xml.crypto.Data;

import static java.lang.System.exit;

public class ValueTransferTest1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        method(a,b);
        System.out.println("a:"+a);
        System.out.println("b:"+b);
    }
    public static void  method(int a,int b){
        a = a* 10;
        b = b* 20;
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        exit(0);

    }
}