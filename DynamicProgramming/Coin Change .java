/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        if(amount == 0 || m == 0)
            return 0;
        int [] count = new int[amount+1];
        count[0] =0;
        count[1] = 1;
        for(int i = 1; i<amount+1; i++)
            count[i] = Integer.MAX_VALUE;
        
        for(int i = 1; i<= amount; i++)
        {
            for(int j = 0; j<m; j++ )
            {
                if(coins[j] <= i)
                {
                    int res = count[i-coins[j]];
                    if(res != Integer.MAX_VALUE && res+1 < count[i])
                        count[i] = res +1;
                    
                }
            }
        }
        if(count[amount] == Integer.MAX_VALUE )
            return -1;
        else
            return count[amount];
    }
}
