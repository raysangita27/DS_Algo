/*
Design a stack which supports the following operations.

Implement the CustomStack class:

CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack or do nothing if the stack reached the maxSize.
void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
int pop() Pops and returns the top of stack or -1 if the stack is empty.
void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in the stack.
 
 */
 class CustomStack {

    int size;
    int[] stackElement ;
    public CustomStack(int maxSize) {
        this.size = maxSize;
        stackElement = new int[size];
    }
    int currentsize = 0;
    public void push(int x) {
        if(currentsize >= size)
            return;
        stackElement[currentsize++] = x;
        
    }
    
    public int pop() {
        if(currentsize == 0)
            return -1;
        return stackElement[--currentsize];
            
    }
    
    public void increment(int k, int val) {
        if(k > size)
        {
            for(int i = 0; i<size; i++)
                stackElement[i] += val; 
        }
        else
        {
            for(int i = 0; i<k; i++)
                stackElement[i] += val; 
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
