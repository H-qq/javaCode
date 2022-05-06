package day06;

import javax.naming.PartialResultException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author hongtao
 * @create 2022-04-24-14:53
 */

public class test {
    public static void main(String[] args) {
        System.out.println(solve(new int[2], 2, 4));
    }

    static int solve(int[] arr, int n, int m) {
        // 请添加具体实现
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(m - arr[i])) {
                return map.size();
            }
            map.put(arr[i], i);
        }
        return 0;
    }

}
