//Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).

 
class Solution {
    public int maxProduct(int[] nums) {
       int len = nums.length;
       int currentProduct = 1;
       int maxProduct = 0;
       for(int i = 0; i < len; i++)
       {
           for(int j = i+1; j<len; j++)
           {
               currentProduct = (nums[i]-1) * (nums[j]-1);
               maxProduct = Math.max(maxProduct, currentProduct);
           }
       }
        return maxProduct;
    }
}
