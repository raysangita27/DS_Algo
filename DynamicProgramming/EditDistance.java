class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] result = new int[len1+1][len2+1];
        for(int i=0; i<=len1; i++)
        {
            for(int j =0; j<=len2; j++)
            {
                if(i==0)
                    result[i][j] = j; // if word1 is empty we need len2 operation 
                else if(j == 0)
                    result[i][j] = i; // if word2 is empty we need len1 operation 
                
                else if( word1.charAt(i-1) == word2.charAt(j-1) ) // if last character same we will ignore that 
                    result[i][j] = result[i-1][j-1];
                else 
                    result[i][j] = 1+ Math.min( result[i][j-1], Math.min(result[i-1][j-1],result[i-1][j]));
                
            }
        }
        return result[len1][len2];
    }
}
