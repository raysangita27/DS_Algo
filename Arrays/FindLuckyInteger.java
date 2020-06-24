//Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
//Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.
class Solution {
    public int findLucky(int[] arr) {
        int len = arr.length;
        if(len == 0)
            return -1;
        if(len == 1 && arr[0] == 1)
            return 1;
        int result = -1;
        HashMap<Integer,Integer> map = new  HashMap<Integer,Integer>();
        for(int i = 0; i< len; i++)
        {
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }
        
        for(int key : map.keySet())
        {
            if(key == map.get(key))
            {
                result = Math.max(result,key);
            }
                
        }
        return result;
    }
}

 
