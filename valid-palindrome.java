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
}
