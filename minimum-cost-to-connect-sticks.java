// https://leetcode.com/problems/minimum-cost-to-connect-sticks/
class minimum-cost-to-connect-sticks {
    // tc -> nlogn, sc-> n
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick : sticks) pq.offer(stick);
        
        int res = 0;
        while(pq.size()>=2){
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a+b);
            res += a+b;
        }
        return res;
    }
}
