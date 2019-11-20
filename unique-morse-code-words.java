// https://leetcode.com/problems/unique-morse-code-words/
class unique-morse-code-words {
    // tc -> n*w, sc-> n*w
    // or tc -> s, sc-> s where s is sum of lengths of words in words
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<word.length(); i++){
                sb.append(arr[word.charAt(i)-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
