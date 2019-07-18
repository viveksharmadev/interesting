// https://leetcode.com/problems/word-ladder/
class word-ladder {
    // tc -> m(list)*n(word), sc-> m*n
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Set<String> wordDict = new HashSet<>(wordList);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i=0; i<size; i++){
                String word = q.poll();
                if(word.equals(endWord)) return level;
                for(int j=0; j<word.length(); j++){
                    char[] arr = word.toCharArray();
                    for(char c='a'; c<='z'; c++){
                        if(arr[j]==c) continue;
                        arr[j] = c;
                        String newWord = new String(arr);
                        if(wordDict.contains(newWord) && !visited.contains(newWord)){
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
