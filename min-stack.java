// https://leetcode.com/problems/min-stack/
class MinStack {
   // tc-> 1, sc-> n
    int min;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(x<=min){
            stack.push(min); // second min
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(!stack.isEmpty() && stack.pop()==min)
            min = stack.pop();
    }
    
    public int top() {
        return !stack.isEmpty() ? stack.peek() : -1;
    }
    
    public int getMin() {
        return min;
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
