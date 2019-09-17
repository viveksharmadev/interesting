// https://leetcode.com/problems/palindrome-number/
class palindrome-number {
    // tc -> n, sc-> 1
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int curr = x;
        int rev = 0;
        while(curr>0){
            int mod = curr%10;
            rev = rev*10 + mod;
            curr /=10;
        }
        return x==rev;
    }
}
