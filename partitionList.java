/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
*
 */
// Given a linked list and a value x, 
// partition it such that all nodes less than x
 // come before nodes greater than or equal to x.

// You should preserve the original relative order 
// of the nodes in each of the two partitions.

// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5. 
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0);
        ListNode smallerTail = smallerHead;
        ListNode biggerHead = new ListNode(0);
        ListNode biggerTail = biggerHead;
        
        
        
        while (head!=null ) {
        	if (head.val<x) {
        		smallerTail.next = head;
        		smallerTail = smallerTail.next;
        	}
        	else {//temp.val>=x
        		biggerTail.next = head;
        		biggerTail = biggerTail.next;
        	}
        	head = head.next;
        }
        smallerTail.next = biggerHead.next;
        biggerTail.next = null;
        return smallerHead.next;
    }
}

