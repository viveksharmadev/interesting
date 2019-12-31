//  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
class remove-all-adjacent-duplicates-in-string {
    // tc -> n, sc-> n-d, where d is the number of duplicate chars
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);            
            if(!stack.isEmpty() && stack.peek()==c)
                stack.pop();
            else
                stack.push(c);            
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : stack) sb.append(c); // it is taking from stack in insertion order, interesting        
        return sb.toString();
    }
}
