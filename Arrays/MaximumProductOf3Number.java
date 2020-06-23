class Solution {
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        Arrays.sort(nums);
        int product = 1;
        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i< len-1; i++)
        {
            int s = i+1;
            int e = len-1;
            while( s < e )
            {
                product = nums[i] * nums[s] * nums[e];
                if(Math.abs(product) > Math.abs(maxProduct))
                    maxProduct = product;
                s++;
                e--;
            }
        }
        return maxProduct;
    }
}
