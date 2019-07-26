// https://leetcode.com/problems/permutation-in-string/

class permutation-in-string {
    // tc -> s2, sc-> s1
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            s1Map.put(c, s1Map.getOrDefault(c,0)+1);            
        }
        
        int start = 0, end = 0, s1MapSize = s1Map.size();
        //boolean res = false;
        while(end < s2.length()){
            char cEnd = s2.charAt(end);
            if(s1Map.containsKey(cEnd)){
                s1Map.put(cEnd, s1Map.get(cEnd)-1);
                if(s1Map.get(cEnd)==0) s1MapSize--;
            }
            end++;
            while(s1MapSize==0){
                char cStart = s2.charAt(start);
                if(s1Map.containsKey(cStart)){
                    if(s1Map.get(cStart)==0) s1MapSize++;
                    s1Map.put(cStart, s1Map.get(cStart)+1);                    
                }
                if(end-start==s1.length()) return true;
                start++;
            }            
        }
        return false;
    }
}
