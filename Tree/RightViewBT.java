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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Queue<TreeNode> tempQueue = new LinkedList<TreeNode>();
        tempQueue.add(root);
        tempQueue.add(null);
        while(!tempQueue.isEmpty() ){
            TreeNode temp = tempQueue.peek();
            if(temp != null){
                result.add(temp.val);
                while(tempQueue.peek() != null )
                {
                    if(temp.right != null)
                        tempQueue.add(temp.right);
                    if(temp.left != null)
                        tempQueue.add(temp.left);
                    tempQueue.remove();
                    temp = tempQueue.peek();
                }
                tempQueue.add(null);
            }
            tempQueue.remove();
        }
        return result;
    }
}
