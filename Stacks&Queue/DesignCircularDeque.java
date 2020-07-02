/*
Design your implementation of the circular double-ended queue (deque).

Your implementation should support following operations:

MyCircularDeque(k): Constructor, set the size of the deque to be k.
insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
getRear(): Gets the last item from Deque. If the deque is empty, return -1.
isEmpty(): Checks whether Deque is empty or not. 
isFull(): Checks whether Deque is full or not.
 

Example:

MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
circularDeque.insertLast(1);			// return true
circularDeque.insertLast(2);			// return true
circularDeque.insertFront(3);			// return true
circularDeque.insertFront(4);			// return false, the queue is full
circularDeque.getRear();  			// return 2
circularDeque.isFull();				// return true
circularDeque.deleteLast();			// return true
circularDeque.insertFront(4);			// return true
circularDeque.getFront();			// return 4
*/

class Node{
    int val;
    Node next;
    Node(int key){
        this.val = key;
        this.next = null;
    }
}
class MyCircularDeque {
    Node head;
    Node front;
    Node rear;
    int size;
    int count = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.size = k;
        head = null;
        front = null;
        rear = null;    
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(count == size)
            return false;
        Node temp = new Node(value);
        count++;
        if(head == null)
        {
            front = temp;
            rear = temp;
            rear.next = front;
            head = temp;
            return true;
        }
        temp.next = front;
        front = temp;
        head = front;
        rear.next = front;
        return true;
        
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(count == size)
            return false;
        Node temp = new Node(value);
        count++;
        if(head == null)
        {
            front = temp;
            rear = temp;
            rear.next = front;
            head = temp;
            return true;
        }
        rear.next = temp;
        rear = rear.next;
        rear.next = front;
        
        return true;    
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(count == 0 || head == null || (front == null && rear== null))
            return false;
        if(front == rear)
        {
            front = null;
            rear = null;
            head = null;
            count --;
            return true;
        }
        front = front.next;
        rear.next = front;
        head = front;
        count--;
        return true;    
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(count == 0 || head == null || (front == null && rear== null))
            return false;
        if(front == rear)
        {
            front = null;
            rear = null;
            head = null;
            count --;
            return true;
        }
        Node current = head;
        while(current.next != rear)
            current = current.next;
        current.next = rear.next;
        rear = current;
        rear.next = front;
        count--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
         if(count == 0 || front == null)
           return -1;
        
        return front.val;    
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
    
         if(count == 0 || rear == null)
           return -1;
        return rear.val; 
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(count == 0 || head == null)
            return true;
        else 
            return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(count == size )
            return true;
        else
            return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
