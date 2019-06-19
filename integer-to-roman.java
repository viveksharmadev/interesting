//  https://leetcode.com/problems/integer-to-roman/

class integer-to-roman {
    // tc -> 1, sc-> 1
    public String intToRoman(int num) {
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] vals =     {1,    4,    5,   9,   10,   40,  50, 90,  100,  400,  500,  900, 1000};
        
        StringBuilder res = new StringBuilder();
        for(int i=vals.length-1; i>=0 && num>0; i--){
            while(num>=vals[i]){
                num -= vals[i];
                res.append(roman[i]);
            }
        }
        return res.toString();
    }
}
