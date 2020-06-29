/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length-1;
        if( lists.length <= 0 || lists == null )
            return null;
        if( lists.length == 1)
            return lists[0];
        
        while(len !=0)
        {
            int i = 0;
            int j = len;
            while(i < j)
            {
                lists[i] = merge(lists[i], lists[j]);
                i++;
                j--;
                if(i >= j)
                    len = j;
            }
        }
        return lists[0];
        
    }
    ListNode merge(ListNode a, ListNode b)
    {
        if(a == null)
            return b;
        else if(b == null)
            return a;
        ListNode result = null;
        if( a.val <= b.val)
        {
            result = a;
            result.next = merge(a.next , b);
        }
        else
        {
            result = b;
            result.next = merge(a , b.next);
        }
        return result;
    }
}
