/*Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int [] result = new int[] {-1, -1};
        
        for(int i =0; i<len; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff) )
            {
                result[0] = map.get(diff);
                result[1] = i;
            }
            else if(!map.containsKey(nums[i]))
                map.put(nums[i],i);
                
        }
        return result;
    }
}
