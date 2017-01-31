/**
*Given a list, rotate the list to the right by k places, where k is non-negative.
*1->2
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
        if(0==k||null==head){
            return head;
        }
       
        ListNode temp = head;
        // 2 situations
        // k is less than the length of the list
        // k is no less than the lenght of the list
        int i = 0;
        while (i<k) {
        	temp = temp.next;
        	
        	i++;
        	if (null==temp) {
        		k = k%(i);
        		i = 0;
        		temp = head;
        	}

        }
        ListNode fast = temp;
       	ListNode slow = head;

       	while(null!=fast.next){
       		fast = fast.next;
       		slow = slow.next;
       	}


       	fast.next = head;
       	head = slow.next;
       	slow.next = null;
       	return head;
    }
}