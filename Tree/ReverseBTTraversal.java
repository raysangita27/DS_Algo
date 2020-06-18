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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> tempQue = new LinkedList<TreeNode>();
        Stack<List<Integer>> tempStk = new Stack<List<Integer>>();
        tempQue.add(root);
        while(!tempQue.isEmpty() ){
            int size = tempQue.size();
            List<Integer> nodeData = new ArrayList<Integer>();
            while(size > 0)
            {
                TreeNode temp = tempQue.remove();
                if(temp.left != null)
                    tempQue.add(temp.left);
                if(temp.right != null)
                    tempQue.add(temp.right);
                nodeData.add(temp.val);
                size --;
            }
            tempStk.push(nodeData);
        }
        while(! tempStk.isEmpty()){
            result.add(tempStk.pop());
        }
        return result;
    }
}
