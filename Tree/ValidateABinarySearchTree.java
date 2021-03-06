/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        return ValidBSTUtil(root, null,null);
    }
    boolean ValidBSTUtil(TreeNode root, TreeNode l, TreeNode r){
        if(root == null)
            return true;
        if(l != null && l.val >= root.val)
            return false;
        if(r != null && r.val <= root.val)
            return false;
     return ValidBSTUtil(root.left, l, root) && ValidBSTUtil(root.right, root, r);
    }
}
