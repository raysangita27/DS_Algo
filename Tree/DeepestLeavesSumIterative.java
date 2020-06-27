/*
Given a binary tree, return the sum of values of its deepest leaves.
 

Example 1:



Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
 

Constraints:

The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.
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
    public int deepestLeavesSum(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        int resultsum = 0;
        while(!que.isEmpty())
        {
            int sum = 0;
            int length = que.size();
            while(length > 0)
            {
                TreeNode temp = que.remove();
                if(temp.left == null && temp.right == null )
                    sum += temp.val;
                if(temp.left != null)
                    que.add(temp.left);
                if(temp.right != null)
                    que.add(temp.right);
                
                length--;
            }
            resultsum = sum;
        }
        return resultsum;
    }
}
