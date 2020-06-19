class Node
{
    char data;
    Node left, right;
    Node(char key)
    {
        data = key;
        left = right = null;
    }
}
public static Node convertExp(String str, int i)
    {
        if(i> str.length() )
            return null;
        Node temp = new Node(str.charAt(i) );
        i++;
        if(i<str.length() ){
        if(str.charAt(i)=='?' )
            temp.left = convertExp(str,i+1);
        if(str.charAt(i)==':' )
            temp.right = convertExp(str, i+1);
        }
        return temp;
    }
