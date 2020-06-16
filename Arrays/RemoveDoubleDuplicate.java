class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<Integer>();
         for(int i=0; i<len; i++)
        {
            nums[i] = nums[i] -1;
        }
        for(int i=0; i<len; i++)
        {
            int index = nums[i]%len;
            nums[index] += len;
        }
        for(int i=0; i<len; i++){
            if(nums[i]/len ==2)
                result.add(i+1);
        }
        return result;
    }
} 
