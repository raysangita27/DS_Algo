class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>> map = new HashMap<HashMap<Character,Integer>,List<String>>();
        for(int j=0; j< strs.length; j++ )
        {
            String st = strs[j];
            HashMap<Character,Integer> temp = new HashMap<Character,Integer>();
            for(int i=0; i<st.length(); i++ )
            {
                if(temp.containsKey(st.charAt(i)) )
                    temp.put(st.charAt(i),temp.get(st.charAt(i))+1 );
                else
                    temp.put(st.charAt(i),1);
            }
            if(map.containsKey(temp) )
                map.get(temp).add(st);
            else{
                List<String> list = new ArrayList<String>();
                list.add(st);
                map.put(temp,list);
            }         
        }
        List<List<String>> result = new ArrayList<List<String>>();
        
        for(HashMap<Character,Integer> key : map.keySet() ){
            result.add(map.get(key) );
        }
        
        return result;
    }
}
