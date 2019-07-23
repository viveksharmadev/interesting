// https://leetcode.com/problems/word-break/
class word-break {
    // tc -> n^2, sc-> n
    public boolean wordBreak(String s, List<String> wordDict) {
        return doesWordBreak(s, new HashSet<String>(wordDict), new Boolean[s.length()], 0);
    }
    
    private boolean doesWordBreak(String s, Set<String> dict, Boolean[] cache, int index){
        if(index==s.length()) return true;
        if(cache[index]!=null) return cache[index];        
        for(int i=index+1; i<=s.length(); i++){
            if(dict.contains(s.substring(index, i)) 
               && doesWordBreak(s, dict, cache, i)){
                return true;
            }
        }
        cache[index] = false;
        return cache[index];
    }
}
