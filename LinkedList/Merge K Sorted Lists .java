/*
Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode head = null;
        ListNode last = null;
        int k = a.size();
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(k,
        new Comparator<ListNode>(){
            public int compare(ListNode x, ListNode y){
                return x.val - y.val;
            }
        });
        for(int i = 0; i<k; i++)
        {
            pq.add(a.get(i) );
        }
        
        while(!pq.isEmpty()){
            ListNode temp = pq.peek();
            pq.remove();
            if(temp.next != null)
                pq.add(temp.next);
            if(head == null)
            {
                head = temp;
                last = temp;
            }
            else{
                last.next = temp;
                last = last.next;
            }
        }
        return head;
            
    }
}
