/*
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        traverseInOrder(root1, list1);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        traverseInOrder(root2, list2);
        List<Integer> result = new ArrayList<Integer>();
        int i = 0; 
        int j = 0;
        while(i < list1.size() && j < list2.size())
        {
            if(list1.get(i) <= list2.get(j)){
                result.add(list1.get(i));
                i++;
            }
            else if(list1.get(i) > list2.get(j)){
                result.add(list2.get(j));
                j++;
            }
        }
        while(i<list1.size())
        {
            result.add(list1.get(i));
                i++;
        }
         while(j<list2.size())
        {
            result.add(list2.get(j));
                j++;
        }
        return result;
    }
    void traverseInOrder(TreeNode root, ArrayList<Integer> list1 )
    {
        if(root == null)
            return ;
        traverseInOrder(root.left, list1);
        list1.add(root.val);
        traverseInOrder(root.right, list1);
    }
}
