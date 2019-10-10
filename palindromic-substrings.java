// https://leetcode.com/problems/palindromic-substrings/
class palindromic-substrings {
    int count = 0;
    public int countSubstrings(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        for(int i=0; i<s.length(); i++){
            extend(s, i, i);
            extend(s, i, i+1);
        }
        return count;
    }
    
    private void extend(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i--)==s.charAt(j++)){
            count++;
        }
    }
}
