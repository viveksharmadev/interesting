// https://leetcode.com/problems/last-stone-weight/
class last-stone-weight {
    // tc -> nlogn, sc-> n
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq 
            = new PriorityQueue<>((a,b) -> b-a);        
        for(int stone : stones) pq.offer(stone);        
        while(pq.size()>=2){
            int b = pq.poll();
            int a = pq.poll();
            if(b>a){
                pq.offer(b-a);
            }
        }        
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
