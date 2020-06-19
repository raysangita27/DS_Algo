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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        int carry = 0;
        
        //creating a dummy node
        ListNode result = new ListNode(0);
        ListNode current = result;
        
        while(l1 != null || l2 != null){
            
            int sum = (l1 != null ? l1.val:0) + (l2 != null ? l2.val:0) + carry;
            
            current.next = new ListNode(sum % 10);
            current = current.next;
            carry = sum/10;
            
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry > 0)
            current.next = new ListNode(carry);
        
        return result.next;
    }
}
