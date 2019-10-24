// https://leetcode.com/problems/verifying-an-alien-dictionary/ 
class verifying-an-alien-dictionary {
    // tc -> NS, sc-> 1
    int[] map = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0; i<order.length(); i++){
            map[order.charAt(i)-'a'] = i;
        }
        
        for(int i=1; i<words.length; i++){
            if(isBigger(words[i-1], words[i])){
                return false;
            }
        }
        return true;
    }
    
    private boolean isBigger(String s1, String s2){
        int l1 = s1.length(), l2 = s2.length();
        for(int i=0; i<l1 && i<l2; i++){
            int diff = map[s1.charAt(i)-'a'] - map[s2.charAt(i)-'a'];
            if(diff>0) return true;
            else if(diff<0) return false;
        }
        return l1>=l2;
    }
}
