/**
*Given a list, rotate the list to the right by k places, where k is non-negative.
*
*For example:
*Given 1->2->3->4->5->NULL and k = 2,
*return 4->5->1->2->3->NULL.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(0==k){
            return head;
        }
        ListNode temp = head;
        for (int i = 1;temp!=null && i<=k;i++) {
        	temp = temp.next;
        }
        ListNode dummy = temp;
        if(temp==null){
            return head;
        }
        while (temp.next!=null) {
        	temp = temp.next;
        }
        temp.next = head;
        head = dummy.next;
        dummy.next = null;
        return head;

    }
}