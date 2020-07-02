/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
class PostIndex{
    int index;
}
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        PostIndex  post = new PostIndex();
        post.index = len-1;
        return buildUtil(inorder, postorder, 0, len-1, post);
    }
    TreeNode buildUtil(int[] inorder, int[] postorder, int l, int r, PostIndex post)
    {
        if(l>r)
            return null;
        int postInd = post.index;
       
        TreeNode root = new TreeNode(postorder[postInd]);
         post.index --;
        if(l == r)
            return root;
       
        int inIndex = searchIndex(inorder, l , r, root.val);
        root.right = buildUtil(inorder, postorder, inIndex+1, r, post);
        root.left = buildUtil(inorder, postorder, l, inIndex-1, post);
        return root;
        
        
    }
    int searchIndex( int[] inorder, int l, int r, int key){
        int i;
        for(i = l; i<=r; i++)
        {
            if(inorder[i] == key)
                break;
        }
        return i;
    }
}
  
