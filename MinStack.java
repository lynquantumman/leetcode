public class MinStack {
    Stack<Integer> stk;
    Stack<Integer> stkMin;
    /** initialize your data structure here. */
    public MinStack() {
        this.stk = new Stack<Integer>();
        this.stkMin = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.stk.push(x);
        if (this.stkMin.empty()||x<=this.getMin()) {
            this.stkMin.push(x);
        }
    }
    
    public void pop() {
        int ele = this.stk.pop();
        if (ele==this.stkMin.peek()) {
            this.stkMin.pop();
        }
    }
    
    public int top() {
        return this.stk.peek();
    }
    
    public int getMin() {
        return this.stkMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */