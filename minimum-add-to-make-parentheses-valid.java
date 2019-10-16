//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

class minimum-add-to-make-parentheses-valid {
    // tc -> n, sc-> n
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='('){
                stack.push(')');
                count++;
            }else if(stack.isEmpty() || stack.peek()!=S.charAt(i)){
                if(!stack.isEmpty()) stack.pop();
                count++;
            }else if(stack.isEmpty() || stack.peek()==S.charAt(i)){
                if(!stack.isEmpty()) stack.pop();
                count--;
            }
        }
        return count;
    }
    // tc -> n, sc -> n
    public int minAddToMakeValid(String S) {
        Deque<Character> stk = new ArrayDeque<>();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') { stk.push(c); }
            else if (stk.isEmpty()) { ++count; }
            else { stk.pop(); }
        }
        return count + stk.size();
    }
    
    // tc -> n, sc -> 1
    public int minAddToMakeValid(String S) {
        int count = 0, stk = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') { ++stk; }
            else if (stk <= 0) { ++count; }
            else { --stk; }
        }
        return count + stk;
    }
    
    // Simpler, I guess:
    // tc -> n, sc-> 1
    public int minAddToMakeValid(String S) {
        int open = 0, close=0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='('){
                open++;
            }else if(S.charAt(i)==')' && open>0){                
                open--;
            }else{                
                close++;
            }
        }
        return open+close;
    }
}
