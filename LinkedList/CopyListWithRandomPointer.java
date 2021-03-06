/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node current = head;
        Node cloneNode = null;
        while(current != null)
        {
            cloneNode = new Node(current.val);
            map.put(current, cloneNode);
           current = current.next;
        }
        
        current = head;
        while(current != null)
        {
            cloneNode = map.get(current);
            cloneNode.next = map.get(current.next);
            cloneNode.random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
}
