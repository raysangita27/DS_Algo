/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
Follow up:

A solution using O(n) space is pretty straight forward.
 devise a constant space solution
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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    TreeNode mid = null;
    public void recoverTree(TreeNode root) {
        if(root == null)    
            return;
        inOrderTravers(root);
        if(first != null && second != null)
        {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        else if(first != null && mid != null)
        {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
        
    }
    void inOrderTravers(TreeNode root)
    {
        if(root == null)
            return ;
        inOrderTravers(root.left);
        if(prev == null)
        {
            prev = root;
        }
        else
        {
            if(root.val < prev.val)
            {
                if(first == null)
                {
                    first = prev;
                    mid = root;
                }
                else
                    second = root;
            }
            prev = root;
        }
       
        inOrderTravers(root.right);
    }
}
