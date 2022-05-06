package day02;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author hongtao
 * @create 2022-04-11-17:48
 */

public class climbTest {
    HashMap<Integer,Integer>map = new HashMap<>();
    public int climb(int n){
        if (n==1) return 1;
        if (n==2) return 2;
        if (null!=map.get(n)){
            return map.get(n);
        }else {
            int result = climb(n-1)+climb(n-2);
            map.put(n,result);
            return result;
        }
    }
}

