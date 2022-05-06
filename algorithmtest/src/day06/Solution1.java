package day06;

/**
 * @author hongtao
 * @create 2022-04-21-23:39
 */

public class Solution1 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));


    }
    public static int maxProfit(int[] prices){
        int profit = 0;
        for (int i = 1;i<prices.length;i++){
            if (prices[i]>prices[i-1]){
                profit += prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}
