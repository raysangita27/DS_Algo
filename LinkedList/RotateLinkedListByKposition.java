/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
            return head;
        if(head.next == null)
            return head;
        int nodeCount = 1;
        ListNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
            nodeCount++;
        }
        
        
        if(nodeCount < k)
            k = k % nodeCount;
        
        k = nodeCount - k;
        if(nodeCount == k || k == 0)
            return head;
        ListNode current = head;
        while( k > 1 && current != null)
        {
            current = current.next;
            k--;
        }
        if(current == null)
            return head;
        ListNode newHead = current.next;
        current.next = null;
      
        temp.next = head;
        head = newHead;
        return head;
    }
}
