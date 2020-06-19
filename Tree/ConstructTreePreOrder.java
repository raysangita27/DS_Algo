class Index{
    int ind;
    
}
class GFG
{
    
    Node constructTree(int n, int pre[], char preLN[])
    {
        Index preInd = new Index();
        preInd.ind = 0;
        return treeUtil(n,pre,preLN,preInd );
    }
    
    Node treeUtil(int n, int[] pre, char[] preLN, Index preInd){
        int index =  preInd.ind;
        if(index >= n)
            return null;
        Node root = new Node(pre[index]);
        preInd.ind++;
        if(preLN[index]=='N' )
        {
            root.left = treeUtil(n,pre,preLN,preInd );
            root.right = treeUtil(n,pre,preLN,preInd );
        }
        return root;
    }
}
