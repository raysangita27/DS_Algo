//In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
//Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
//We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        int levelX = findLevel(root, x, 0);
        int levelY = findLevel(root, y, 0);
        if(levelX == levelY && !isSiblings(root, x, y) )
            return true;
        return false;
    }
    boolean isSiblings(TreeNode root, int x, int y){
        if(root == null)
            return false;
        if(root.left == null )
            return isSiblings(root.right, x, y) ;
        else if(root.right == null)
            return isSiblings(root.left, x, y) ;
        if((root.left.val == x && root.right.val == y) ||(root.left.val == y && root.right.val == x) || isSiblings(root.left, x, y) || isSiblings(root.right, x, y) )
            return true;
        else
            return false;
    }
    int findLevel(TreeNode root, int key, int level){
        if(root == null)
            return 0;
        if(root.val == key )
            return level+1;
        int leftVal = findLevel(root.left, key, level+1);
        if(leftVal == 0)
            return findLevel(root.right, key, level+1);
        else
            return leftVal;
    }
}
