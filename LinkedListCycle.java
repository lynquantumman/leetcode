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
    public boolean hasCycle(ListNode head) {
    	if (null==head) {
    		return false;
    	}
        ListNode wugui = head;//tortoise
        ListNode tuzi = head;//hare

        while (null!=tuzi.next && null!=tuzi.next.next) {
        	wugui = wugui.next;
        	tuzi = tuzi.next.next;
        	if (wugui==tuzi) {
        		return true;
        	}
        }
        return false;
    }
}