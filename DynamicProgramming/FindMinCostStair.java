/*
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int c1 = cost[1];
        int c2 = cost[0];
        for(int i = 2; i<n; i++)
        {
            int newCost = cost[i] + Math.min(c1,c2);
            c2 = c1;
            c1 = newCost;
        }
        return Math.min(c1,c2);
    }
}
