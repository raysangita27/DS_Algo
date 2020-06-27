/*
You are given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
*/

class Solution {
    public String reverseParentheses(String s) {
        int len = s.length();
        if(len == 0)
            return null;
        Stack<Character> stk = new Stack<Character>();
        for (char c : s.toCharArray())
        {
            if(c==')')
            {
                Queue<Character> q = new LinkedList<Character>();
                while(!stk.isEmpty() && stk.peek()!= '(')
                {
                    q.add(stk.pop());
                }
                if(!stk.isEmpty())
                    stk.pop();
                while(!q.isEmpty())
                    stk.push(q.remove());
            }
            else
            {
                stk.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stk.isEmpty())
        {
            result.append(stk.pop());
        }
        return result.reverse().toString();
    }
}

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            String ret = new Solution().reverseParentheses(s);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}
