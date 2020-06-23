class Solution {
    public int maxPower(String s) {
        int len = s.length();
        int totalCount = 1;
        int count = 1;
        int val = s.charAt(0);
        for(int i = 1; i < len; i++)
        {
            if(val == s.charAt(i) )
            {
                count++;
            }
            else
            {
                count = 1;
                val = s.charAt(i);
            }
            totalCount = Math.max(totalCount, count);
        }
        return totalCount;
    }
}
