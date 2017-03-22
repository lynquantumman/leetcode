import java.util.Hashtable;
public class LRUCache {
	private class DLinkedNode{
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode next;
		public DLinkedNode(int k,int v){
			key = k;
			value = v;
		}
	}
	int capacity = 0;
	int elementsNumber = 0;
	// here head and tail are always not null
	DLinkedNode head = new DLinkedNode(0,0);

	DLinkedNode tail = new DLinkedNode(0,0);
	Hashtable<Integer,DLinkedNode> ht;
    public LRUCache(int capacity) {
    	this.capacity = capacity;	
        ht = new Hashtable<Integer,DLinkedNode>();
        this.head.next = tail;
        this.tail.pre  = head;
    }
    
    public int get(int key) {
    	if (!ht.containsKey(key)) {
    		return -1;
    	}
        DLinkedNode node = ht.get(key);
      
        remove(node);
        addToTheHead(node);
        ht.put(key,head.next); 
        return this.head.next.value;
    }
    
    public void put(int key, int value) {
    	if (ht.containsKey(key)) {
    		DLinkedNode node = ht.get(key);
    		node.value = value;
    		remove(node);
    		addToTheHead(node);
    	}
    	else{
    		if (this.elementsNumber<this.capacity) {
    			DLinkedNode node = new DLinkedNode(key,value);
    			addToTheHead(node);
        		ht.put(key,node);
        		this.elementsNumber++;
	        }
	        else {
	        	ht.remove(this.tail.pre.key);
	        	remove(this.tail.pre);
	        	DLinkedNode node = new DLinkedNode(key,value);
    			addToTheHead(node);
        		ht.put(key,node);
	        }
    	}

        
    }

    private void addToTheHead(DLinkedNode node){
    	node.next = head.next;
    	node.pre = head;
    	head.next.pre = node;
    	head.next = node;

    }

    private void remove(DLinkedNode node){
    	node.pre.next = node.next;
    	node.next.pre = node.pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */