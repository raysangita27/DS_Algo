/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return ;
        Deque<Integer> q = new LinkedList<>();
       // q.add(root);
        ListNode current = head;
        while(current != null)
        {
            q.addLast(current.val);
            current = current.next;
        }
        int level = 0;
        current = head;
        while(!q.isEmpty())
        {
            if(level%2 == 0)
            {
                current.val = q.removeFirst();
            }
            else
            {
                current.val = q.removeLast();
            }
            current = current.next;
            level ++;
        }
        
        
    }
}
