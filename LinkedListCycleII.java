/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
    	if (null==head) {
    		return null;
    	}
    	ListNode hare = head;
    	ListNode turtle = head;
        while(hare.next!=null&&hare.next.next!=null){
        	hare = hare.next.next;
        	turtle = turtle.next;
        	if (hare==turtle) {
        		// situation of cycling
        		ListNode newStart = head;
        		while(newStart!=turtle){

        		
        			newStart = newStart.next;
        			turtle = turtle.next;
        		}
        		return newStart;
        	}
        }
        // situation of not cycling
        return null;
    }
}