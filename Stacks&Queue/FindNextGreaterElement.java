/*
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
*/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums2.length == 0 || nums1.length== 0)
            return new int[]{};
       Stack<Integer> stk = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        stk.push(nums2[0]);
        for(int i = 1; i< nums2.length; i++)
        {
            int next = nums2[i];
            if(!stk.isEmpty())
            {
                int element = stk.pop();
                while(element < next){
                    map.put(element, next);
                    if(stk.isEmpty())
                        break;
                    element = stk.pop();
                }
                if(element > next)
                {
                     stk.push(element);
                }
                   
            }
            stk.push(next);
        }
        
        int[] result = new int[nums1.length];
        for(int i = 0; i< nums1.length; i++)
        {
            if(map.containsKey(nums1[i]))
                result[i] = map.get(nums1[i]);
            else
                result[i] = -1;
        }
        return result;
    }
}
