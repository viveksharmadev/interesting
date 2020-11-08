// https://leetcode.com/problems/roman-to-integer/
class Solution {
    // tc -> n, sc-> 1
    public int romanToInt(String s) {
        int res = 0;
        
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            if(c=='I') res += 1;
            
            if(c=='V') res += 5;
            
            if(c=='X') res += 10;
            
            if(c=='L') res += 50;
            
            if(c=='C') res += 100;
            
            if(c=='D') res += 500;
            
            if(c=='M') res += 1000;
        }
        
        if(s.indexOf("IV") != -1 || s.indexOf("IX") != -1) res -= 2;
        
        if(s.indexOf("XL") != -1 || s.indexOf("XC") != -1) res -= 20;
        
        if(s.indexOf("CD") != -1 || s.indexOf("CM") != -1) res -= 200;
        
        return res;
    }
}
