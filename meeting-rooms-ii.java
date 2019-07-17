// https://leetcode.com/problems/meeting-rooms-ii/
class meeting-rooms-ii {
    // tc -> nlogn, sc-> n
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0)
            return 0;
        // sort start time
        Arrays.sort(intervals, 
                   new Comparator<int[]>(){
                       @Override
                       public int compare(int[] a, int[] b){
                           return a[0]-b[0];
                       }
                   });
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            new Comparator<int[]>(){
                @Override
                       public int compare(int[] a, int[] b){
                           return a[1]-b[1];
                       }
            }
        );
        
        for(int[] interval : intervals){
            if(!pq.isEmpty() && pq.peek()[1]<=interval[0])
                pq.poll();
            pq.offer(interval);
        }
        
        return pq.size();
    }
}
