/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

 

Example:



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
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
class BSTIterator {

    ArrayList<TreeNode> treeList;
    public BSTIterator(TreeNode root) {
        treeList = new   ArrayList<TreeNode>();
        inOrder(root, treeList);
    }
    int start = -1;
    /** @return the next smallest number */
    public int next() {
        if(start < treeList.size())
            return treeList.get(++start).val;
        else
            return -1;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(start < treeList.size()-1)
            return true;
        return false;
    }
    void inOrder(TreeNode root,  ArrayList<TreeNode> treeList)
    {
        if(root == null)
            return;
        inOrder(root.left, treeList);
        treeList.add(root);
        inOrder(root.right, treeList);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
