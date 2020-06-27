/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

 

Example 1:



Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
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
    public int goodNodes(TreeNode root) {
        if(root == null)
            return 0;
        int parent = root.val;
        return checkGoodNodes(root,parent);
    }
    int checkGoodNodes(TreeNode root, int parent)
    {
        if(root == null)
            return 0;
        int key = root.val;
        int result = 0;
        if( key >=parent)
        {
            parent = key;
            result = 1;
        }
        result += checkGoodNodes(root.left , parent);
        result += checkGoodNodes(root.right ,parent);
        return result;
    }
}
