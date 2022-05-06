package day06;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hongtao
 * @create 2022-04-22-0:42
 */

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));

    }

        public static boolean containsDuplicate(int[] nums) {
            boolean isTrue = false;
            Set map =new HashSet();
            int len = nums.length;
            for(int i = 0;i<len;i++){
                map.add(nums[i]);
            }
            if(map.size()<len){
                return true;
            }
            return isTrue;
        }

}
