/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode right = head;
        ListNode left = null;
        ListNode temp  = head;
        while(right!=null){
        	temp = right.next;
        	right.next = left;
        	left = right;
        	right = temp;
        }
        return left;
    }
}