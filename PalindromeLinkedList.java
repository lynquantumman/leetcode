/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
        	temp = temp.next;
        	count++;
        }

        ListNode right = head;
        ListNode left = null;
        temp = head;
        for(int i = 1;i<=count/2;i++){
        		temp = right;
        		right = right.next;
        		temp.next = left;
        		left = temp;
        	}
        if (count%2==1) {//odd situation
        	right = right.next;
        }
        while(left!=null){
        	if(left.val!=right.val)
        		return false;
        	left = left.next;
        	right = right.next;
        }
        return true;
    }
}