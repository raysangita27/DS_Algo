/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Stack<Node> stk = new Stack<Node>();
        stk.push(root);
        while(!stk.isEmpty())
        {
            Node temp = stk.pop();
            result.add(temp.val);
            List<Node> childList = temp.children;
            for(int i = childList.size()-1; i>=0; i--)
                stk.push(childList.get(i));
            
        }
        return result;
    }
}
