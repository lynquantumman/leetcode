public class RandomizedSet {
    ArrayList<Integer> al;
    HashMap<Integer,Integer> hm;
    int size;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.al = new ArrayList<Integer>();
        this.hm = new HashMap<Integer,Integer>();
        this.size = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (this.hm.containsKey(val)) {
            return false;
        }
        this.al.add(val);

        this.hm.put(val,size);
        this.size++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer pos = hm.get(val);
        if (pos==null) {
            return false;
        }
        this.hm.remove(val);
        Integer swapEle = al.get(this.size-1);
        
        hm.replace(swapEle,this.size-1,pos);//if contanisKey then put 
        swap(pos,this.size-1);
        
        
        al.remove(this.size-1);
        this.size--;
        return true;
    }
    
    private void swap(int pos1,int pos2){
        int temp = this.al.get(pos1);
        this.al.set(pos1,this.al.get(pos2));
        this.al.set(pos2,temp); 
    }
    /** Get a random element from the set. */
    public int getRandom() {
        Random rdm = new Random();
        int pos = rdm.nextInt(this.size);
        return al.get(pos);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */