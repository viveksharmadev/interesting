//https://leetcode.com/problems/first-unique-character-in-a-string/
class first-unique-character-in-a-string{
    // tc -> n, sc-> 1
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for(int i=0; i<s.length(); i++){
            map[s.charAt(i)-'a']++;
        }
        
        for(int i=0; i<s.length(); i++){
            if(map[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}
