class Solution {
    public int[][] generateMatrix(int n) {
        int m =n;
        int[][] resultMatrix = new int[m][n];
        int l = 0;
        int k = 0;
        int value =1;
        while(l< m && k<n){
            
            for(int i=k; i<n; i++)
            {
                resultMatrix[l][i] = value++;
            }
            l++;
            for(int i = l; i<m; i++)
            {
                resultMatrix[i][n-1] = value++;
            }
            n--;
            if(l<m)
            {
                for(int i = n-1; i>=k; i--)
                {
                    resultMatrix[m-1][i] = value++;
                }
                m--;
            }
            if(k<n)
            {
                for(int i = m-1; i>=l; i--)
                {
                    resultMatrix[i][k] = value++;
                }
                k++;
            }
        }
        return resultMatrix;
    }
}
