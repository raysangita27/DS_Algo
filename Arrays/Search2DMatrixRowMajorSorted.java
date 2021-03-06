/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = m-1;
        while(i <= j)
        {
            int mid = (i+j)/2;
            if(matrix[mid][0] <= target && target <= matrix[mid][n-1])
                return searchColumnWise(matrix[mid], n-1, target);
            else if(matrix[mid][0]< target)
                i = mid+1;
            else
                j = mid-1;
        }
        return false;
    }
    boolean searchColumnWise(int[] arr, int n, int target)
    {
        int i = 0;
        int j = n;
        while(i <= j)
        {
            int mid = (i+j)/2;
            if(arr[mid] == target)
                return true;
            else if(arr[mid] <target)
                i = mid+1;
            else
                j = mid-1;
        }
        return false;
    }
}
