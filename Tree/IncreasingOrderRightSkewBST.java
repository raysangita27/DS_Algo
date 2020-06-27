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
    public TreeNode increasingBST(TreeNode root) {
        if(root == null)
            return null;
        List<Integer> result = new ArrayList<Integer>();
        result = inOrder(root, new ArrayList<Integer>());
        TreeNode newRoot = new TreeNode(0);
        TreeNode cur = newRoot;
        for(int val : result)
        {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        return newRoot.right;
    }
    ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> result )
    {
        if(root == null)
            return result;
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
        return result;
    }
}
