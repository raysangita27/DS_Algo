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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        if(root == null)
            return result;
        Queue<TreeNode> tempQue = new LinkedList<TreeNode>();
        tempQue.add(root);
        while(!tempQue.isEmpty() )
        {
            int size = tempQue.size();
            int nodeCount = size;
            double sum = 0;
            while(size > 0)
            {
                TreeNode temp = tempQue.remove();
                if(temp.left != null)
                    tempQue.add(temp.left);
                if(temp.right != null)
                    tempQue.add(temp.right);
                sum = sum + temp.val;
                size --;
            }
            double avg = (sum/nodeCount);
            result.add(avg);
        }
        return result;
    }
}
