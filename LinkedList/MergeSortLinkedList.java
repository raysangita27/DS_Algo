/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode a = sortList(head);
        ListNode b = sortList(midNext);
        return merge(a,b);
    }
    ListNode merge(ListNode a, ListNode b)
    {
        if(a == null)
            return b;
        if(b == null)
            return a;
        ListNode result = null;
        if(a.val <= b.val)
        {
            result = a;
            result.next = merge(a.next, b);
        }
        else
        {
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
    }
    ListNode findMid(ListNode head){
        if(head == null )
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null && slow != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
