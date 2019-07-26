// https://leetcode.com/problems/valid-parentheses/
class valid-parentheses {
    // tc -> n, sc -> n
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push(')');
            }else if(s.charAt(i)=='{'){
                stack.push('}');
            }else if(s.charAt(i)=='['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop()!=s.charAt(i)){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
