/*
Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
Note:

The sum of node values in any subtree won't exceed the range of 32-bit integer.
All the tilt values won't exceed the range of 32-bit integer.
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
class Sum{
    int val;
}
class Solution {
    //static int  sum = 0;
    public int findTilt(TreeNode root) {
        Sum sum = new Sum();
        findTreeUtil(root,sum);
        return sum.val;
        
        
    }
    int findTreeUtil(TreeNode root, Sum sum){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        int l = findTreeUtil(root.left ,sum);
        int r = findTreeUtil(root.right, sum);
        sum.val += Math.abs(l-r);
        return l+r+ root.val;
    }
}
