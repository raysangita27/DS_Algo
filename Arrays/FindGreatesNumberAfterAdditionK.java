//Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.
//For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the greatest number of candies among them. Notice that multiple kids can have the greatest number of candies.

 class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        int len = candies.length;
        int greatestCandy = 0;
        for( int i = 0; i< len; i++)
        {
            greatestCandy = Math.max(greatestCandy, candies[i]);
        }
        for(int i = 0; i< len; i++)
        {
            if(candies[i]+ extraCandies >= greatestCandy)
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }
}
