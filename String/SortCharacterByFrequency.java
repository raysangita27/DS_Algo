/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
*/


class Solution {
    public String frequencySort(String s){
        int len = s.length();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i<len; i++)
        {
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character,Integer>>(){
            public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character,Integer> o2){
                if(o1.getValue() == o2.getValue())
                    return o1.getKey() - o2.getKey();
                else
                    return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder result = new StringBuilder();
        for(Map.Entry<Character,Integer> c : list){
            int count = c.getValue();
            char r = c.getKey();
            while(count >0)
            {
                result.append(r);
                count--;
            }
            
        }
        return result.toString();
    }
}

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            String ret = new Solution().frequencySort(s);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}
