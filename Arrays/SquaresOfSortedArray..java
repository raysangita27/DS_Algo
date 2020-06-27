/*
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
*/

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int len = arr.length;
        Arrays.sort(arr);
        int m = arr[(len - 1)/2];
        int i = 0; 
        int j = len-1;
        int[] result = new int[k];
        int c = 0;
        int count = 0;
        while(i <= j)
        {
            if(Math.abs(arr[i]-m)== Math.abs(arr[j]-m))
            {
                 if(arr[i] >arr[j])
                 {
                     result[c] = arr[i];
                     i++;
                 }
                else
                {
                     result[c] = arr[j];
                     j--;
                }
                c++;
            }
            else if(Math.abs(arr[i]-m)< Math.abs(arr[j]-m))
            {
                 result[c] = arr[j];
                 j--;
                 c++;
            }
            else
            {
                result[c] = arr[i];
                i++;
                c++;
            }
            if(c == k)
            {
                break;
            }
               
        }
        return result;
    }
}
