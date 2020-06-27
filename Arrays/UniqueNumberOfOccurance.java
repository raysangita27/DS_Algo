/*
Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.

 

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
*/
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if(arr.length == 0 || arr.length == 1)
            return true;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i<arr.length; i++)
        {
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }
        int count = map.get(arr[0]);
        List<Integer> result = new ArrayList<Integer>();
        for(int val: map.values())
        {
            if(result.contains(val))
                return false;
            else
                result.add(val);
        }
        return true;
    }
}
