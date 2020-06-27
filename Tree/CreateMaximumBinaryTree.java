//Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

//The root is the maximum number in the array.
//The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
//The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
//Construct the maximum tree by the given array and output the root node of this tree.
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        return createTreeUtil(nums, 0, len-1);
        
    }
    TreeNode createTreeUtil(int[] nums, int l, int r)
    {
        if(l > r)
            return null;
        int maxInd = findMaxElement(nums,l, r);
        TreeNode root = new TreeNode(nums[maxInd]);
        root.left = createTreeUtil(nums, l, maxInd-1);
        root.right = createTreeUtil(nums, maxInd + 1, r);
        return root;
    }
    int findMaxElement(int[]nums, int l, int r)
    {
        int max = nums[l];
        int maxInd = l;
        for(int i = l; i<=r; i++)
        {
            if(nums[i] > max)
            {
                max = nums[i];
                maxInd = i;
            }
        }
        return maxInd;
    }
}
