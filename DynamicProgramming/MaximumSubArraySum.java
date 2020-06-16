
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0)
        { 
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i = 0; i<n; i++)
                a[i] = in.nextInt();
            System.out.println(maxSubArray(a,n));
        	t--;
        }
	}
    static int maxSubArray(int[] nums) {
        int len = nums.length;
        int maxSum = nums[0];
        int curSum = nums[0];
        for(int i= 1; i<len; i++)
        {
            curSum = Math.max(nums[i] , curSum+nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
