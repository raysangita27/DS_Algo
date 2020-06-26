/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        int leftVal = 0;
        while(!que.isEmpty() )
        {
            int size = que.size();
            TreeNode temp = que.peek();
            leftVal = temp.val;
            while(size > 0)
            {
               TreeNode current = que.remove();
                if(current.left != null)
                    que.add(current.left);
                if(current.right != null)
                    que.add(current.right);
                size--;
            }
        }
        return leftVal;
    }
}
