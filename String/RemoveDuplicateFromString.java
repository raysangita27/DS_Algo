/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"
Output: "abc"
Example 2:

Input: "cbacdcbc"
Output: "acdb"
*/
class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length()== 0 || s.length()==1)
            return s;
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stk = new Stack<Character>();
        for(char c : s.toCharArray())
            freq[c - 'a']++;
        
        for(char c : s.toCharArray())
        {
            freq[c - 'a']--;
            if(visited[c-'a'])
                continue;
            
            while(!stk.isEmpty() && c <stk.peek() && freq[stk.peek() - 'a']!=0)
            {
                
                visited[stk.peek() - 'a'] = false;
                stk.pop();
            }
            stk.push(c);
            visited[c-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty())
        {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
