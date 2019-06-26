// https://leetcode.com/problems/add-and-search-word-data-structure-design/

class WordDictionary {
    // tc -> n, sc-> n
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a']==null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return doesWordExist(word, 0, root);
    }
    
    private boolean doesWordExist(String word, int index, TrieNode node){
        if(index==word.length()) return node.isWord;
        char c = word.charAt(index);
        if(c!='.'){
            return node.children[c-'a']!=null 
                && doesWordExist(word, index+1, node.children[c-'a']);
        }else{
            for(int i=0; i<node.children.length; i++){
                if(node.children[i]!=null 
                   && doesWordExist(word, index+1, node.children[i])){
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
