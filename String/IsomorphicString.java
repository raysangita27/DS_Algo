/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0 && t.length() == 0)
            return true;
        if(s.length() == 0 || t.length() == 0)
            return false;
        if(s.length() != t.length())
            return false;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i< s.length(); i++)
        {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(!map.containsKey(c1))
            {
                if(map.containsValue(c2))
                    return false;
                else
                    map.put(c1,c2);
            } 
            else
            {
                if(!map.get(c1).equals(c2))
                    return false;
            }
        }
        return true;
    }
}
