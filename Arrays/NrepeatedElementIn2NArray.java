/*
In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.
*/
class Solution {
    public int repeatedNTimes(int[] A) {
        int len = A.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<len; i++)
        {
            if(map.containsKey(A[i]))
            {
                int count = map.get(A[i])+1;
                if(count == len/2)
                    return A[i];
                else
                    map.put(A[i],count);
            }
            else
                map.put(A[i],1);
        }
        return -1;
    }
}
