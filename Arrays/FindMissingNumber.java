class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int len = nums.length;
        for(int i=0; i<len; i++)
        {
            nums[i] = nums[i]-1;
        }
         for(int i=0; i<len; i++)
        {
            int index = nums[i]%len;
            nums[index] += len;
        }
        for(int i=0; i<len; i++){
            if(nums[i]/len ==0)
                result.add(i+1);
        }
        return result;
    }
}
