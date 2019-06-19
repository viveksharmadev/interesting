// https://leetcode.com/problems/remove-k-digits/
class remove-k-digits {
    /// tc -> n, sc - > n
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<num.length(); i++){
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){                
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        
        while(k>0){
            stack.pop();
            k--;
        }
        
        
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        
        while(res.length()>1 && res.charAt(res.length()-1)=='0')
            res.deleteCharAt(res.length()-1);
        
        return res.reverse().toString();
    }
}
