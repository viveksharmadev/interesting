// https://leetcode.com/problems/find-the-town-judge/

class find-the-town-judge {
    // tc -> E, sc-> V
    public int findJudge(int N, int[][] trust) {
        int[] inArrows = new int[N+1];
        int[] outArrows = new int[N+1];
        
        for(int[] t : trust){
            outArrows[t[0]]++;
            inArrows[t[1]]++;
        }
        
        for(int i=1; i<=N; i++){
            if(inArrows[i]==N-1 && outArrows[i]==0){
                return i;
            }
        }
        
        return -1;
     }
}
