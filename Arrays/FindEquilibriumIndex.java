class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int leftSum = 0;
        int sum = 0;
        for(int i = 0; i< len; i++)
            sum += nums[i];
        for(int i = 0; i < len; i++)
        {
            sum = sum - nums[i];
            if(sum == leftSum )
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
