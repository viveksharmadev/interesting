// https://leetcode.com/problems/partition-labels/
class partition-labels {
    // tc -> n, sc-> n
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if(S==null || S.length()==0) return res;
        
        int[] map = new int[26];
        
        for(int i=0; i<S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }
        
        int end = 0, start = 0;
        for(int i=0; i<S.length(); i++){
             end = Math.max(end, map[S.charAt(i)-'a']);
            if(end==i){                
                res.add(end-start+1);
                start = end+1;
            }
        }
        return res;
    }
}
