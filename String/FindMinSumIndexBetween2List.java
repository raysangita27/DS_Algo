/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
*/


class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i< list1.length; i++)
            map.put(list1[i],i);
        int minIndexSum = Integer.MAX_VALUE;
        int secondIndex = -1;
        ArrayList<String> resultList = new  ArrayList<String>();
        for(int i = 0; i< list2.length && i<= minIndexSum ; i++)
        {
            
            if(map.containsKey(list2[i]))
            {
                int sum = i + map.get(list2[i]);
                if(sum < minIndexSum)
                {
                    resultList.clear();
                    resultList.add(list2[i]);
                    minIndexSum = sum;
                }
                else if( sum == minIndexSum)
                {
                    resultList.add(list2[i]);     
                }
            }
        }
        return resultList.toArray(new String[resultList.size()]); 
    }
}
