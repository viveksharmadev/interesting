//https://leetcode.com/problems/minimum-window-substring/
class Solution {
    // tc -> s, sc-> t
    public String minWindow(String s, String t) {
        int start = 0, end = 0, maxLength = Integer.MAX_VALUE; 
        Map<Character, Integer> freqMap = new HashMap<>();
        
        String res = "";
        for(int i=0; i<t.length(); i++){
            freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i),0)+1);
        }
        
        int mapSize = freqMap.size();
        
        while(end < s.length()){
            char cEnd = s.charAt(end);
            if(freqMap.containsKey(cEnd)){
                freqMap.put(cEnd, freqMap.get(cEnd)-1);
                if(freqMap.get(cEnd)==0) mapSize--;
            }
            end++;
            while(mapSize==0){
                char cStart = s.charAt(start);
                if(freqMap.containsKey(cStart)){
                    if(freqMap.get(cStart)==0) mapSize++;
                    freqMap.put(cStart, freqMap.get(cStart)+1);
                }
                if(end-start < maxLength){
                    maxLength = end-start;
                    res = s.substring(start, start + maxLength);
                }
                start++;
            }
        }
        return res;
    }
}
