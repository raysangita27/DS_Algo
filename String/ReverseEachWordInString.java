class Solution {
    public String reverseWords(String s) {
        String[] temp =s.split(" ");
        String result = " ";
        for(int i = temp.length-1; i>= 0; i--)
        {
            if(!temp[i].trim().isEmpty() ){
                result += temp[i];
                result += " ";
            }
        }
        return result.trim();
    }
}
