/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int maxP = nums[0];
        int minP = nums[0];
        int res = nums[0];
        for(int i = 1; i<len; i++ )
        {
            int maxT = maxP;
            int minT = minP;
            
            maxP = Math.max(Math.max(maxT*nums[i], minT*nums[i]) ,nums[i]);
            minP = Math.min(Math.min(maxT*nums[i], minT*nums[i]) ,nums[i]);
            res = Math.max(res, maxP);
        }
        return res;
    }
}
