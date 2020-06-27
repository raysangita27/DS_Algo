/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
      
        int firstIndex = findFirstElement(nums,0,len-1, target, len);
        int lastIndex = findLastElement(nums,0,len-1, target,len);
        return new int[]{firstIndex,lastIndex};
//         if(index == -1)
//             return new int[]{-1,-1};
//         int i;
//         int j;
//         if(index > 0)
//         i = index-1;
//         else 
//         i = 0;
//         if(index <len-1)
//          j = index+1;
//         else
//          j = len-1;
//         while(nums[i]== target && i>0)
//             i--;
//         while(nums[j] == target && j<len)
//             j++;
//         return new int[]{i,j};
            
    }
    int findFirstElement(int[]nums, int l, int r, int key, int n)
    {
        if(l> r)
            return -1;
        int mid = (l+r)/2;
        if(( mid==0 || nums[mid-1]<key ) && nums[mid] == key  )
            return mid;
        else if(nums[mid]>=key)
            return findFirstElement(nums,l ,mid-1, key, n);
        else
            return findFirstElement(nums, mid+1, r, key, n);
    }
    int findLastElement(int[]nums, int l, int r, int key, int n)
    {
        if(l> r)
            return -1;
        int mid = (l+r)/2;
        if(nums[mid] == key && (mid==n-1 || nums[mid+1]> nums[mid]))
            return mid;
        else if(nums[mid]>key)
            return findLastElement(nums,l ,mid-1, key, n);
        else
            return findLastElement(nums, mid+1, r, key, n);
    }
}
