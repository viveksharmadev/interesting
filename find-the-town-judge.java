// https://leetcode.com/problems/find-the-town-judge/

class find-the-town-judge {
    // tc -> T+N , sc-> N
    public int findJudge(int N, int[][] trust) {
        int[] trusting = new int[N];
        int[] trusted = new int[N];
        
        for(int[] t : trust){
            trusting[t[0]-1]++;
            trusted[t[1]-1]++;
        }
        
        for(int i=0; i<N; i++){
            if(trusting[i]==0 && trusted[i]==N-1)
                return i+1;
        }
        
        return -1;
    }
    
    // Compact code
    // tc -> T+N , sc-> N
    public int findJudge(int N, int[][] trust) {
        int[] trusted = new int[N];
        
        for(int[] t : trust){
            trusted[t[0]-1]--;
            trusted[t[1]-1]++;
        }
        
        for(int i=0; i<N; i++){
            if(trusted[i]==N-1)
                return i+1;
        }
        
        return -1;
    }
}
