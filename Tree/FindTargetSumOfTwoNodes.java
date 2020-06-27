/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True

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
    HashSet<Integer> set = new HashSet<Integer>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        if(findTarget(root.left,k))
            return true;
        if(set.contains(k-root.val))
            return true;
        set.add(root.val);
        if(findTarget(root.right, k))
            return true;
        return false;
    }
}
