/*
You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C. 
*/
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int lenA = A.size();
        int lenB = B.size();
        int lenC = C.size();
        int i = 0;
        int j = 0;
        int k = 0;
        int result = Integer.MAX_VALUE;
        while(i < lenA && j < lenB && k<lenC)
        {
            int max = Math.max(A.get(i), Math.max(B.get(j),C.get(k)) );
            int min = Math.min(A.get(i), Math.min(B.get(j),C.get(k)) );
            result = Math.min(result,(max - min) );
            if(A.get(i) == min )
                i++;
            else if(B.get(j) == min )
                j++;
            else
                k++;
        }
        if(result == Integer.MAX_VALUE)
            return -1;
        else
            return result;
        
    }
}
