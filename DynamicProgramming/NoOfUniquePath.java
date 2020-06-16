class Solution {
    public int uniquePaths(int m, int n) {
        int[][] resultPath = new int[m][n];
        for(int i=0; i<n; i++)
            resultPath[0][i] = 1;
        for(int i=0; i<m; i++)
            resultPath[i][0] = 1;
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
                resultPath[i][j] = resultPath[i-1][j] + resultPath[i][j-1];
        }
        return resultPath[m-1][n-1];
    }
}
