package day06;

import java.util.*;

/**
 * @author hongtao
 * @create 2022-04-24-10:35
 */

public class leet {
    public static void main(String[] args) {
        int[][] nums = {{7,34,45,10,12,27,13}, {27,21,45,10,12,13}};
        System.out.println(nums.length);
        System.out.println(intersection(nums));
    }

    public static List<Integer> intersection(int[][] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] a = new int[1024];
        for (int i =0;i<a.length;i++){
            a[i] = 1;
        }
        int index = 1;
        int count =1;
        for (int i = 0; i <nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (map.containsKey(nums[i][j])) {
                    map.put(nums[i][j],a[nums[i][j]]+=1 );

                } else {
                    map.put(nums[i][j], 1);
                }
            }
        }
        Iterator entInfo = map.entrySet().iterator();
        while (entInfo.hasNext()) {
            Map.Entry entry = (Map.Entry) entInfo.next();
            Object key = entry.getKey();
            if ((int) entry.getValue()==nums.length){
                list.add((int) entry.getKey());
            }
        }
        Collections.sort(list);
        return list;
    }
}
