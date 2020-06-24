class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int currentSum = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int result = 0;
        for(int i = 0; i< len; i++)
        {
            currentSum += nums[i];
            if(currentSum == k)
                result ++;
            if(map.containsKey(currentSum - k) )
                result += map.get(currentSum - k);
            
            if(!map.containsKey(currentSum))
                map.put(currentSum , 1);
            else
                map.put(currentSum, map.get(currentSum) +1);
        }
        return result;
    }
}
