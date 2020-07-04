/*
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?

*/
public class Solution {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int[][] p = new int[A+1][A+1];
        for(int lineNo = 0; lineNo <= A; lineNo ++)
        {
            for(int i = 0; i<= lineNo; i++)
            {
                if(i == 0 || lineNo == i)
                    p[lineNo][i] = 1;
                else
                {
                    p[lineNo][i] = p[lineNo-1][i-1] + p[lineNo-1][i];
                }
            }
        }
        for(int i = 0; i<=A; i++)
            result.add(p[A][i]);
            return result;
    }
}
