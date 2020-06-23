//Write a function that takes a string as input and reverse only the vowels of a string.
class Solution {
    public String reverseVowels(String s) {
       int len = s.length();
        if(len == 0 || len == 1)
            return s;
        int start = 0;
        int end = len-1;
        char[] tempString = s.toCharArray();
        while(start <= end){
            if(!checkVowel(tempString[start]))
            {
                start++;
                continue;
            }
                
            if(!checkVowel(tempString[end]))
            {
                end--;
                continue;
            }
            if(start != end && checkVowel(tempString[start]) && checkVowel(tempString[end]))
            {
                char temp = tempString[start];
                tempString[start] = tempString[end];
                tempString[end] = temp;
                start ++;
                end --;
            }
            else
                break;
            
        }
        return new String(tempString);
            
    }
    boolean checkVowel(char c)
    {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' )
            return true;
        else
            return false;
    }
}
