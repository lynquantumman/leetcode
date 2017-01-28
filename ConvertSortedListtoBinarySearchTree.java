/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // the length of the singly-linked list
        int count = 0;
        ListNode temp = head;
        while(temp!=null) {
        	count++;
        	temp = temp.next;
        }
        return sortedListToBSTRecursive(head,count);
    }

    private TreeNode sortedListToBSTRecursive(ListNode head, int len){
    	if (0==len) {
    		return null;
    	}
    	if (len==1) {
    		return new TreeNode(head.val);//when head==null is true, the len==1 is true 
    	}
    	int half = len/2;
    	ListNode temp = head;
    	for (int i = 0;i<half-1;i++ ) {
    		temp = temp.next;
    	}
    	// temp.next is located in the center
    	ListNode right = temp.next.next;
    	TreeNode ans = new TreeNode(temp.next.val);
    	temp.next = null;
    	ListNode left = head;
    	

    	ans.left = sortedListToBSTRecursive(left,half);
    	ans.right = sortedListToBSTRecursive(right,len-half-1);
    	return ans;
    }
}