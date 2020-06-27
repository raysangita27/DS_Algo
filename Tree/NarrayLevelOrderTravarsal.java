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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        while(!que.isEmpty())
        {
            List<Integer> temp = new ArrayList<Integer>();
            int length = que.size();
            while(length > 0)
            {
                Node tempNode = que.remove();
                temp.add(tempNode.val);
                var childList = tempNode.children;
                for(Node c : childList)
                    que.add(c);
                length--;
            }
            result.add(temp);
        }
        return result;
    }
}
