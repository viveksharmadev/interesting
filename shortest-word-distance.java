// https://leetcode.com/problems/shortest-word-distance/
class shortest-word-distance {
    // tc -> n, sc-> 1
    public int shortestDistance(String[] words, String word1, String word2) {
        int dist = words.length;
        int index1=-1, index2=-1;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1)){
                index1 = i;
            }else if(words[i].equals(word2)){
                index2 = i;
            }

            if(index1!=-1 && index2!=-1){
               dist = Math.min(dist, Math.abs(index2-index1));
            }
        }        
        return dist;
    }
}
