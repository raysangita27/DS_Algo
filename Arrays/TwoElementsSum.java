/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        int i = 0;
        int j = len-1;
        while(i < j){
            if(nums[i] + nums[j] == target)
            {
                result[0] = i+1;
                result[1] = j+1;
                break;
            }
            else if(nums[i] + nums[j] > target)
                j--;
            else if(nums[i] + nums[j] < target)
                i++;
        }
        return result;
    }
}
