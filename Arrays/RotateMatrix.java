class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        transpose(matrix,m,n);
        rotateColumn(matrix,m,n);
    }
    public void transpose(int[][] a, int m, int n){
        for(int i=0; i<m; i++)
        {
            for(int j=i; j<n; j++)
            {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
            
    }
    public void rotateColumn(int[][] a, int m, int n){
        for(int i=0; i<m; i++)
        {
            int l = 0; int r = n-1;
            while(l<=r)
            {
                int temp = a[i][l];
                a[i][l] = a[i][r];
                a[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}
