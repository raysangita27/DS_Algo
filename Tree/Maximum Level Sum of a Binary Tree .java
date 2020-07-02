/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

 

Example 1:



Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
 

Note:

The number of nodes in the given tree is between 1 and 10^4.
-10^5 <= node.val <= 10^5
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
    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return 0;
        int level = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int maxSum = 0;
        int minLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            while(size > 0)
            {
                TreeNode tree = q.remove();
                sum += tree.val;
                if(tree.left != null)
                    q.add(tree.left);
                if(tree.right != null)
                    q.add(tree.right);  
                size--;
            }
            if(maxSum < sum)
            {
                maxSum = sum;
                minLevel = level;
            }
            level++;
        }
        return minLevel;
        
    }
}
