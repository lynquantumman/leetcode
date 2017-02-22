/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA==null||headB==null) {
    		return null;
    	}
    	ListNode endA = headA;
    	ListNode endB = headB;
        while(endA.next!=null || endB.next!=null) {
        	endA = endA.next==null?endA:endA.next;
        	endB = endB.next==null?endB:endB.next;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        if (endB==endA) {
        	while (tempA!=tempB) {
        		tempA = tempA.next==null?headB:tempA.next;
        		tempB = tempB.next==null?headA:tempB.next;
        	}
        	return tempB;
        }
        else {
        	return null;
        }
    }
}