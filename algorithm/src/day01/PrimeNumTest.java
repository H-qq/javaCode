package day01;

public class PrimeNumTest {
    public static void main(String[] args) {
        for (int i = 2;i<=100;i++){
            boolean isFlag = true;
            for (int j =2 ; j<= Math.sqrt(i);j++){         //优化二:只需要开方  只针对质数自然数有效
                if (i % j == 0){   //
                    isFlag  = false;
                    break;         //优化一；只对非质数的自然是有效
                }
            }
            if (isFlag == true){
                System.out.println(i);
            }
        }
    }
}
