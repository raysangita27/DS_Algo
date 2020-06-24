//Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
class Solution {
    public int removeDuplicates(int[] nums) {
         int j=-1;
        if(nums.length == 0 || nums.length == 1)
            return nums.length;
        int numCount = 1;
        for(int i = 0; i< nums.length-1; i++)
        {
            if(nums[i]!= nums[i+1])
            {
                nums[++j] = nums[i];
                numCount = 1;
            }
            else if(nums[i] == nums[i+1]){
                if(numCount <2)
                    nums[++j] = nums[i];
                  numCount++;  
            }
                
        }
        nums[++j] = nums[nums.length-1];
        return j+1;
    }
}
