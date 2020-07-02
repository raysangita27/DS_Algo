/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
Accepted
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
    public void flatten(TreeNode root) {
    
        if(root == null || root.left == null && root.right == null)
            return;
        if(root.left != null){
            flatten(root.left);
            TreeNode next = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode cur = root.right;
            while(cur.right != null)
                cur = cur.right;
            cur.right = next;
        }
        flatten(root.right);
    }
}
