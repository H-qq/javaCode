package day04;

import java.util.Arrays;

/**
 * @author hongtao
 * @create 2022-04-14-20:21
 */
class ListNode{
   int val;
   ListNode next;
   public void ListNode(int x){
       val = x;
   }
}

public class Main {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        ListNode listNode = new ListNode();
        listNode.ListNode(0);
        listNode.next.ListNode(1);
        listNode.next.next.ListNode(2);
        System.out.println();
        System.out.println(Arrays.toString(s1.reversePrint(listNode)));


    }
}
class Solution {
    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp!=null){
            temp.next = head;
            len++;
        }
        int index = len -1 ;
        int[] res = new int[len];
        while (temp!=null){
            res[index--] = temp.val;
            temp = temp.next;
        }
        return res;
    }
}
