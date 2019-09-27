// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
class longest-word-in-dictionary-through-deleting {
    // tc -> s*d, sc-> Math.max(s,d)
    public String findLongestWord(String s, List<String> d) {
        String res = ""; int max = 0;
        for(String str : d){
            if(isSubSequence(str, s)){
                if(res.length()<str.length()) res = str;
                else if(res.length()==str.length() && str.compareTo(res)<0)
                    res = str;
            }
        }        
        return res;
    }
    
    private boolean isSubSequence(String str, String s){
        int i=0, j = 0;
        while(i<str.length() && j<s.length()){
                if(str.charAt(i)==s.charAt(j++)){               
                    i++;
                }
            }
        return i==str.length();
    }
}
