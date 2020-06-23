class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    public MyQueue() {
        stk1 = new Stack<Integer>();
        stk2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stk1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stk1.size() == 0 )
            return -1;
        while(stk1.size() > 1)
        {
            stk2.push(stk1.pop() );
        }
        int val = stk1.pop();
        while(!stk2.isEmpty() )
        {
            stk1.push(stk2.pop());
        }
        return val;
    }
    
    /** Get the front element. */
    public int peek() {
          if(stk1.size() == 0 )
            return -1;
        while(stk1.size() > 1)
        {
            stk2.push(stk1.pop() );
        }
        int val = stk1.peek();
        while(!stk2.isEmpty() )
        {
            stk1.push(stk2.pop());
        }
        return val;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stk1.size()==0 )
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
