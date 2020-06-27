/*
Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
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
    public int minDiffInBST(TreeNode root) {
        if(root == null)
            return 0;
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        inOrder = findInOrder(root, new ArrayList<Integer>());
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i< inOrder.size()-1; i++)
        {
            int diff = inOrder.get(i+1) - inOrder.get(i);
            minValue = Math.min(diff, minValue);
        }
        return minValue;
    }
    
    public ArrayList<Integer> findInOrder(TreeNode root, ArrayList<Integer> list){
        if(root == null)
            return list;
        findInOrder(root.left, list);
        list.add(root.val);
        findInOrder(root.right, list);
        return list;
    }
}
