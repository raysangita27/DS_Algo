

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
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
	        System.out.println(rob(a) );
        	t--;
        }

	}
	static int rob(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int includeEle = nums[0];
        int excludeEle = 0;
        for(int i=1; i<len; i++)
        {
            int newExcEle = Math.max(includeEle,excludeEle);
            includeEle = excludeEle + nums[i];
            excludeEle = newExcEle;
        }
        return Math.max(excludeEle, includeEle);
    }
}
