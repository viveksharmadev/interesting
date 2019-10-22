// https://leetcode.com/problems/valid-palindrome/
class valid-palindrome {
    // tc-> n, sc-> n
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
                sb.append(s.charAt(i));
        }
        StringBuilder rev = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
            rev.append(s.charAt(i));
        }
        //System.out.println(rev.toString());
        //System.out.println(sb.toString());
        return rev.toString().toLowerCase()
            .equals(sb.reverse().toString().toLowerCase());
    }
    
    // tc -> n, sc-> 1
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        s = s.toLowerCase();
        while(start < end){
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }else{
                if(s.charAt(start)!=s.charAt(end)){
                    return false;
                }else{
                    start++; end--;
                }
            }
        }
        return true;
    }
}
