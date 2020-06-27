/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
 
    for(int i=0; i<nums.length; i++){
        if(map.containsKey(nums[i])){
            int pre = map.get(nums[i]);
            if(i-pre<=k)
                return true;
        }
 
        map.put(nums[i], i);
    }
 
    return false;
    }
}
