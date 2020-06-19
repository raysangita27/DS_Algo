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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>  result = new ArrayList<List<Integer>>();
        
        if(root == null)
            return result;
        Stack<TreeNode> stk1 = new Stack<TreeNode>();
        Stack<TreeNode> stk2 = new Stack<TreeNode>();
        stk1.push(root);
        while(!stk1.isEmpty() || !stk2.isEmpty() )
        {
            int size1 = stk1.size();
            if(size1 > 0){
                List<Integer> tempList1 = new ArrayList<Integer>();
                while(size1 > 0 )
                {
                    TreeNode temp = stk1.pop();
                    if(temp.left != null)
                        stk2.push(temp.left);
                    if(temp.right != null)
                        stk2.push(temp.right);
                    tempList1.add(temp.val);
                    size1 --;
                }
                if(tempList1 != null)
                    result.add(tempList1);
            }
            
            int size2 = stk2.size();
            if(size2 > 0){
                List<Integer> tempList2 = new ArrayList<Integer>();
                while(size2 > 0 )
                {
                    TreeNode temp = stk2.pop();
                    if(temp.right != null)
                        stk1.push(temp.right);
                    if(temp.left != null)
                        stk1.push(temp.left);
                    tempList2.add(temp.val);
                    size2 --;
                }  
                if(tempList2 != null)
                    result.add(tempList2);
            }
        }
        return result;
    }
}
