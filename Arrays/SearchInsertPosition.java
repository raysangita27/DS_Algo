class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchUtil(nums, target, 0, nums.length-1);
        
    }
    
    public int searchUtil(int[] nums, int target, int l, int r){
        if(l > r)
            return l;
        int mid = (l + r)/2;
        if(nums[mid] == target)
            return mid;
        if(nums[mid] < target)
            return searchUtil(nums, target, mid+1, r);
        else 
            return searchUtil(nums, target, l , mid-1);
    }
}
