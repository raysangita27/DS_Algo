//Given a binary tree root and an integer target, delete all the leaf nodes with value target.
//Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you can't).
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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
            return null;
        root.left = removeLeafNodes(root.left, target);
        if(isLeaf(root) && root.val == target)
        {
            root = null;
            return root;
        }
        
        root.right = removeLeafNodes(root.right, target);
        if(root.left == null && root.right == null && root.val == target)
            return null;
        else
            return root;
        
    }
    boolean isLeaf(TreeNode root)
    {
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return true;
        return false;
    }
}
