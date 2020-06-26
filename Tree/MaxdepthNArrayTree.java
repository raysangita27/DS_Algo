/*
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: 3
*/

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
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        int level = 0;
        while(!que.isEmpty())
        {
            int length = que.size();
            while(length > 0)
            {
                 Node temp = que.remove();
                 var childList = temp.children;
                 for(Node c : childList)
                     que.add(c);
                length--;
            }
            level ++;
            
        }
        return level;
    }
}
