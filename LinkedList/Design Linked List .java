/*
Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement these functions in your linked list class:

get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
addAtTail(val) : Append a node of value val to the last element of the linked list.
addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 

Example:

Input: 
["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
[[],[1],[3],[1,2],[1],[1],[1]]
Output:  
[null,null,null,null,2,null,3]

Explanation:
MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
linkedList.get(1);            // returns 2
linkedList.deleteAtIndex(1);  // now the linked list is 1->3
linkedList.get(1);            // returns 3
 

Constraints:

0 <= index,val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex and deleteAtIndex.
*/
class Node{
    int val;
    Node next;
    Node(int key){
        val = key;
        next = null;
    }
}
class MyLinkedList {

    Node head;
    int count ;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        count = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(head == null )
            return -1;
        if(index < 0 || index > count-1)
            return -1;
        if(index == 0)
            return head.val;
        Node current = head;
        int counter = 0;
        while(current != null && counter!= index)
        {
            current = current.next;
            counter++;
        }
        if(current == null && index != count)
            return -1;
        return current.val;
            
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        count++;
        if(head == null)
        {
            head = new Node(val);
            return ;
        }
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        count++;
        if(head == null)
        {
            head = new Node(val);
            return ;
        }
        Node current = head;
        while(current.next != null)
            current = current.next;
        current.next = new Node(val);
        
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0)
        {
            addAtHead(val);
            return;
        }
        if(index == count)
        {
            addAtTail(val);
            return;
        }
        if(index > count)
            return;
            
        Node current = head;
        int counter = 0;
        while(current != null && counter != index-1)
        {
            current = current.next;
            counter++;
        }
      //  if(current == null && index-1 != counter)
       //     return ;
        Node temp = new Node(val);
        temp.next = current.next;
        current.next = temp;
        count++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >count-1)
            return;
        if(index== 0)
        {
            head = head.next;
            count--;
            return;
        }
     
        Node current = head;
        Node prev = null;
        int counter = 0;
        while(current != null && counter!= index)
        {
            prev = current;
            current = current.next;
            counter++;
        }
        // if(current == null && index-1 != 1)
        //     return ;
        if(current.next == null)
            prev.next = null;
        else
        prev.next = current.next;
        count--;
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
