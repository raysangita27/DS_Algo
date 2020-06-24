class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if(len == 0 )
            return true;
        if(len == 1)
            return false;
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0; i< len; i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stk.push(s.charAt(i));
            else if((s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') && stk.isEmpty())
                return false;
            else if(s.charAt(i) == ')'  && stk.peek() ==  '(')
            {
                stk.pop();
            }
            else if(s.charAt(i) == '}' && stk.peek() ==  '{')
            {
                stk.pop();
            }
            else if(s.charAt(i) == ']' && stk.peek() ==  '[')
            {
                stk.pop();
            }
            else 
                return false;
        }
        if(stk.isEmpty())
            return true;
        else 
            return false;
    }
}
