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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        List<Integer> result = new ArrayList<Integer>();
        result = inOrder(root,new ArrayList<Integer>());
        if(result.size()<k)
            return 0;
        else
            return result.get(k-1);
            
    }
    List<Integer> inOrder(TreeNode root,  ArrayList<Integer> list ){
        if(root == null)
            return list;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
        return list;
    }
}
