/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
//1.克隆一个链表
//2.新链表的节点的随机指针都指向原节点
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {

        //copy without random pointer
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode anotherDummy = new RandomListNode(0);
        dummy.next = head;
        RandomListNode tempA = dummy;
        RandomListNode tempB = anotherDummy;
        while (tempA.next!=null) {
        	tempB.next =  new RandomListNode(tempA.next.label);
        	tempA = tempA.next;
        	tempB = tempB.next;
        }


        HashMap<RandomListNode, RandomListNode> mapAtoB = new HashMap<RandomListNode,RandomListNode>();
        tempA = dummy;
        tempB = anotherDummy;
        while(tempA.next!=null){
        	mapAtoB.put(tempA.next,tempB.next);
        	tempA = tempA.next;
        	tempB = tempB.next;
        }
        //k=random,value=list of the start dots
        HashMap<RandomListNode,List<RandomListNode>> randomA = new HashMap<RandomListNode,List<RandomListNode>>();
        tempA = dummy;
        while(tempA.next!=null){
        	List<RandomListNode> needToBeAdded = randomA.getOrDefault(tempA.next.random, new ArrayList<RandomListNode>());
        	needToBeAdded.add(tempA.next);
        	randomA.put(tempA.next.random,needToBeAdded); 
        	tempA = tempA.next;
        }
        tempA = dummy;
        tempB = anotherDummy;
        List<RandomListNode> randomList;
        while(tempB.next!=null){
        	//all nodes in A that point to tampA.next
        	randomList = randomA.get(tempA.next);
        	if (null!=randomList) {
        		for (RandomListNode each:randomList ) {
	        		//mapping from A to B
	        		mapAtoB.get(each).random = tempB.next;
        		}
        	}
        	
        	tempA = tempA.next;
        	tempB = tempB.next;
        }
        return anotherDummy.next;
    }
}