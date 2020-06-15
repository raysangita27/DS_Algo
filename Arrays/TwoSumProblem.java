
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
            else
                map.put(nums[i],i);
                
        }
        return result;
    }
}
