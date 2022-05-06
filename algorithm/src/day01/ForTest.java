package day01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ForTest {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int [] a = new int[]{1,7,9,10};
        s1.twoSum(a,8);


    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer,Integer> hashMap = new HashMap<>(len-1);
        hashMap.put(nums[0],0);
        for (int i =1;i<len;i++){
            if (hashMap.containsKey(target-nums[i])){
                return new int[]{i,hashMap.get(target-nums[i])};
            }else{
                hashMap.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }
}