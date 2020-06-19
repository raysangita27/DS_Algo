class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        //if both strings are empty
        
        if(n == 0)
        {
            if((p == "*") || m == 0 )
                return true;
        } 
        boolean [][] count = new boolean[n+1][m+1];
        
        //if pattern is empty
        for(int i = 0; i< n+1; i++)
            Arrays.fill(count[i], false);
        count[0][0] = true;
        
        // matching the pattern with empty string
        for(int j = 1; j<m+1; j++)
        {
            if(p.charAt(j-1) == '*')
                count[0][j] = count[0][j-1];
        }
        
        for( int i = 1; i < n+1; i++)
        {
            for(int j = 1; j < m+1; j++)
            {
                if(p.charAt(j-1) == '*' )
                    count[i][j] = count[i-1][j] || count[i][j-1]; 
                else if (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1) )
                    count[i][j] = count[i-1][j-1];
                else 
                    count[i][j] = false;
            }   
        }
        return count[n][m];
        
    }
}
