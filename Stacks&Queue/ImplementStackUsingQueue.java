class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> que1 ;
    Queue<Integer> que2 ;
    public MyStack() {
        que1 = new LinkedList<Integer>();
        que2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        que1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int val = -1;
        if(que1.size()==0 )
            return val;
        while(que1.size() >1)
        {
            que2.add(que1.remove());
        }
        val = que1.remove();
        while(que2.size() >0)
        {
            que1.add(que2.remove());
        }
        return val;
    }
    
    /** Get the top element. */
    public int top() {
        int val = -1;
        if(que1.size()==0 )
            return val;
        while(que1.size() >1)
        {
            que2.add(que1.remove());
        }
        val = que1.remove();
        while(!que2.isEmpty() )
        {
            que1.add(que2.remove());
        }
        que1.add(val);
        return val;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(que1.size() == 0 )
            return true;
        else
            return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
