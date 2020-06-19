class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
//Recursive solution
class Tree
{
    int height(Node node) 
    {
        if(node == null)
            return 0;
        return Math.max(height(node.left), height(node.right) )+1;
    }
}

//Iterative solution
class Tree
{
    int height(Node node) 
    {
       if(node == null)
            return 0;
       Queue<Node> q = new LinkedList<Node>();
       q.add(node);
       int h =0;
       while(!q.isEmpty())
       {
           int size = q.size();
           while(size>0){
               Node temp = q.remove();
               if(temp.left != null)
                    q.add(temp.left);
               if(temp.right != null)
                    q.add(temp.right);
                size --;
           }
           h++;
       }
       return h;
    }
}

