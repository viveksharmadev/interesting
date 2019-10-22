// https://leetcode.com/problems/valid-palindrome-ii/
class Solution {
    // tc -> n, sc-> 1
    public boolean validPalindrome(String s) {
        int start = -1, end = s.length();
        while(++start < --end){
            if(s.charAt(start)!=s.charAt(end)){
                return isPalindrom(s, start-1, end)
                    || isPalindrom(s, start, end+1);
            }
        }
        return true;
    }
    
    private boolean isPalindrom(String str, int start, int end){
        while(++start < --end){
            if(str.charAt(start)!=str.charAt(end)) return false;
        }
        return true;
    }
}
