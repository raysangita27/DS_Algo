class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0)
            return result;
        int n = matrix[0].length;
        
        //row index
        int l =0;
        //column index
        int k =0;
        
        while(l < m && k < n)
        {
            for(int i = k ; i< n; i++)
                result.add(matrix[l][i]);
            l++;
            
            for(int i = l ; i< m; i++)
                result.add(matrix[i][n-1]);
            n--;
            
            if(l < m){
                for(int i = n-1; i>=k; i--)
                    result.add(matrix[m-1][i]);
                m--;
            }
            
            if(k < n){
                for(int i = m-1; i>= l; i--)
                    result.add(matrix[i][k]);
                k++;
            }
                
        }
        return result;
    }
}
