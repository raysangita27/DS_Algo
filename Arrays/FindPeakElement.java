class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0)
            return -1;
        return findPeakUtil(nums,0, nums.length-1,nums.length);
    }
    int findPeakUtil(int[] nums, int l, int r, int n)
    {
        
        int mid = l +(r-l)/2;
        if((mid == 0 || nums[mid - 1] <= nums[mid]  ) && ( mid == n - 1 || nums[mid + 1] <= nums[mid] ))
            return mid;
        if( mid > 0 && nums[mid - 1] > nums[mid] )
            return findPeakUtil(nums, l, mid-1, n);
            
        else 
            return findPeakUtil(nums, mid+1, r, n);
    }
}
