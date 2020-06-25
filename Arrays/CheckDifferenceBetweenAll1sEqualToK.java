/*
Given an array nums of 0s and 1s and an integer k, return True if all 1's are at least k places away from each other, otherwise return False.

Example 1:

Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other.

*/

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int len = nums.length;
        int startInd = -1;
        for(int i = 0; i< len; i++)
        {
            if(nums[i] == 1)
            {
                if(startInd == -1)
                    startInd = i;
                else
                {
                    int diff = i-startInd;
                    if(diff - 1 >= k)
                        startInd = i;
                    else
                        return false;
                }
            }
        }
        return true;
    }
}
