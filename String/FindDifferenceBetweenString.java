class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char val=(char) 0 ;
        for(int i = 0; i< s.length(); i++)
        {
            if(!map.containsKey(s.charAt(i)) )
                map.put(s.charAt(i),1);
            else 
                map.put(s.charAt(i),map.get(s.charAt(i))+1 );
        }
        for(int i = 0; i< t.length(); i++)
        {
            if(map.containsKey(t.charAt(i)) )
            {
                if(map.get(t.charAt(i)) >0)
                    map.put(t.charAt(i),map.get(t.charAt(i))-1 );
                else
                    val = t.charAt(i);
            }
            else 
                val = t.charAt(i);
        }
        return val;
    }
}
