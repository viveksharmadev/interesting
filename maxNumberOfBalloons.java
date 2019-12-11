// https://leetcode.com/problems/maximum-number-of-balloons/
class maxNumberOfBalloons {
    // tc -> n, sc-> 1
    public int maxNumberOfBalloons(String text) {
        char[] map = new char[26];
        for(int i=0; i<text.length(); i++){
            map[text.charAt(i)-'a']++;
        }
        
        int min = map[1]; // b frequency
        min = Math.min(min, map[0]); // a frequency
        min = Math.min(min, map[11]/2); // l frequency
        min = Math.min(min, map[14]/2); // o frequency
        min = Math.min(min, map[13]); // n frequency
        
        return min;
    }
}
