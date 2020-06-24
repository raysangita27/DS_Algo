class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int count = 0;
        int maxCount = -1;
        int val = 1;
        for(int i = 0; i< len; i++)
        {
            if(nums[i] == val)
            {
                count++;
            }
            else
            {
                count = 0;
            }
            maxCount = Math.max(maxCount , count);
        }
        return maxCount;
    }
}
