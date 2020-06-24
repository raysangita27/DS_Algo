class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i< nums1.length; i++)
            set.add(nums1[i]);
        for(int i = 0; i< nums2.length; i++)
        {
            if(set.contains(nums2[i]) )
            {
                if(!result.contains(nums2[i]))
                    result.add(nums2[i]);
            }
                
        }
        int[] val = new int[result.size()];
       for(int i = 0; i< result.size(); i++ )
           val[i] = result.get(i);
        return val;
    }
}
